package com.ufal.aracomp.Coordinator;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.ufal.aracomp.utils.Connection;
import com.ufal.aracomp.utils.TimeUtils;

public class Coordinator {

	private static final int PORT = 5000;
	private static final int NUM_CLIENTS = 4;

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(PORT);
		System.out.println("Coordenador aguardado conexões...");

		List<Connection> connections = new ArrayList<>();
		List<Long> times = new ArrayList<>();

		long coordinatorTime = TimeUtils.getCurrentSimulatedTimeWithOffset();
		System.out
				.println("Tempo do coordenador antes da sincronização: " + TimeUtils.formatTimestamp(coordinatorTime));

		for (int i = 0; i < NUM_CLIENTS; i++) {
			Socket clientSocket = serverSocket.accept();
			Connection connection = new Connection(clientSocket);
			long clientTime = connection.receiveTime();

			System.out.println("Tempo recebido do cliente " + (i + 1) + ": " + TimeUtils.formatTimestamp(clientTime));

			connections.add(connection);
			times.add(clientTime);
		}

		times.add(coordinatorTime);

		long sum = 0;
		for (long t : times) sum += t;
		long average = sum / times.size();

		System.out.println("Tempo médio calculado: " + TimeUtils.formatTimestamp(average));

		for (int i = 0; i < connections.size(); i++) {
			Connection connection = connections.get(i);
			long adjustment = average - times.get(i);
			
			connection.sendTime(adjustment);
			long clientTime = connection.receiveTime();
			System.out.println("Tempo do cliente " + (i + 1) + " após sincronização: " + TimeUtils.formatTimestamp(clientTime));
			connections.get(i).close();
		}

		coordinatorTime += (average - coordinatorTime);
		System.out.println("Tempo do coordenador após sincronização: " + TimeUtils.formatTimestamp(coordinatorTime));
		
		serverSocket.close();

	}
}
