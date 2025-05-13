package com.ufal.aracomp.client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.ufal.aracomp.utils.Connection;
import com.ufal.aracomp.utils.TimeUtils;

public class Client {

	private static final String HOST = "localhost";
	private static final int PORT = 5000;

	public static void main(String[] args) throws UnknownHostException, IOException {
		long localTime = TimeUtils.getCurrentSimulatedTimeWithOffset();

		System.out.println("Tempo antes da sincronização: " + TimeUtils.formatTimestamp(localTime));

		Socket socket = new Socket(HOST, PORT);
		Connection connection = new Connection(socket);
		
		connection.sendTime(localTime);
		long adjustment = connection.receiveTime();
		localTime += adjustment;
		connection.sendTime(localTime);

		System.out.println("Tempo após sincronização: " + TimeUtils.formatTimestamp(localTime));

		connection.close();
	}
}
