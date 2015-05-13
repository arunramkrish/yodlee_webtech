package com.yodlee.training.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
	public static boolean running = true;

	public static void main(String[] args) {
		try {
			ExecutorService executors = Executors.newFixedThreadPool(50);
			ServerSocket serverSocket = new ServerSocket(8866);
			serverSocket.setSoTimeout(10000);
			executors.execute(new CommandHandler());
			while (running) {
				Socket client = serverSocket.accept();
				executors.execute(new RequestHandler(client));
			}
			serverSocket.close();
			executors.shutdown();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

class RequestHandler implements Runnable {
	private Socket clientSocket = null;

	public RequestHandler(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}

	public void run() {
		try {
			InputStream is = clientSocket.getInputStream();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(is));

//			char[] read = new char[100];
//			while (true) {
//				int count = reader.read(read);
//				if (count == -1) continue;
//				System.out.println(String.copyValueOf(read, 0, count));
//			}
			String request = reader.readLine();
			while (!"logout".equals(request)) {
				System.out.println(request);
				request = reader.readLine();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}

	}
}

class CommandHandler implements Runnable {
	public void run() {
		do {
			Scanner s = new Scanner(System.in);
			String command = s.nextLine();
			if ("quit".equals(command)) {
				Server.running = false;
				break;
			}
		} while (true);
	}
}