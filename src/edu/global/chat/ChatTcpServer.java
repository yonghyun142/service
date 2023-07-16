package edu.global.chat;

import java.net.ServerSocket;
import java.net.Socket;

import edu.global.chat.way.Receiver;
import edu.global.chat.way.Sender;

public class ChatTcpServer {

	public static void main(String[]args) {
		ServerSocket serverSocket = null;
		
		Socket socket = null;
		
		try {
		
		//포트번호
		serverSocket = new ServerSocket(8888);
		System.out.println("서버가 준비되었습니다.");
		
		socket = serverSocket.accept();
		
		Sender sender = new Sender(socket);
		Receiver receiver = new Receiver(socket);
		
		sender.start();
		receiver.start();
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
