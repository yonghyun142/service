package edu.global.chat;

import java.net.ServerSocket;
import java.net.Socket;

import edu.global.chat.way.Receiver;
import edu.global.chat.way.Sender;

public class ChatTcpClient {
   public static void main(String[] args) {
      String serverIP = "192.168.0.20";
      
      try {
         Socket socket = new Socket(serverIP, 8888);
         System.out.println("서버에 연결되었습니다.");
         Sender sender = new Sender(socket);
         Receiver receiver = new Receiver(socket);
         
         
         sender.start();
         receiver.start();
      } catch (Exception e) {
         
         e.addSuppressed(e);
      }
      
   }
}