package com.yodlee.training.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		try {
			while (true) {
				Socket socket = new Socket("127.0.0.1", 8866);
				OutputStream os = socket.getOutputStream();
				PrintWriter writer = new PrintWriter(os);
//				Scanner scanner = new Scanner(System.in);
//				String input = scanner.nextLine();
				writer.println("input\n");
				writer.flush();
//				if ("logout".equals(input)) {
//					break;
//				}
			}

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
