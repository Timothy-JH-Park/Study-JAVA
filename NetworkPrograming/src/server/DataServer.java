package server;

import java.net.*;
import java.io.*;
import java.util.*;

public class DataServer {

	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(9101);
		
		while(true) {
			
			System.out.println("Ŭ���̾�Ʈ�� ��û�� ��ٸ��ϴ�...");
			// Ŭ���̾�Ʈ�� ��û�� ��ٸ���.
			Socket socket = serverSocket.accept();
			System.out.println("Ŭ���̾�Ʈ�� ���ӵǾ���... [" 
			+ socket.getRemoteSocketAddress() + "]");
			
			// Ŭ�����Ʈ�� ��û�� �����Ǹ� ���ο� socket�� ������
			// �� Ŭ���̾�Ʈ�� ����Ѵ�.
			Thread thread = new NewSocket(socket);
			thread.start();
			
			
			
		}
	}
}

class NewSocket extends Thread {
	Socket socket;
	public NewSocket(Socket socket) {
		this.socket = socket;
	}
	public void run() {
		try {
			
			OutputStream ostream = socket.getOutputStream();
			PrintWriter writer = new PrintWriter(ostream, true);
			writer.println(Calendar.getInstance().getTime());
			Thread.sleep(1000*10);
			socket.close();
			System.out.println("Ŭ���̾�Ʈ���� ������ �����մϴ�.");
			
		} catch (Exception e) {
			
		} finally {
			try {
				 socket.close();
			} catch (Exception ignore) {
				
			}
		}
	}
}