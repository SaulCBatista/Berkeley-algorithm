package com.ufal.aracomp.utils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Connection {
	
	private Socket socket;
	private DataInputStream input;
	private DataOutputStream output;
	
	public Connection(Socket socket) throws IOException {
		this.socket = socket;
		this.input = new DataInputStream(socket.getInputStream());
		this.output = new DataOutputStream(socket.getOutputStream());
	}
	
	public long receiveTime() throws IOException {
		return input.readLong();
	}
	
	public void sendTime(long time) throws IOException {
		output.writeLong(time);
	}
	
	public void close() throws IOException {
		socket.close();
	}
}
