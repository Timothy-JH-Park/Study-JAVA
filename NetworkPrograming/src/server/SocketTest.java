package server;

import java.io.*;
import java.net.*;

public class SocketTest {

	public static void main(String[] args) {
		try (Socket socket = new Socket("time-c.nist.gov", 13)) {
			InputStream inStream = socket.getInputStream();
			BufferedReader reader = 
					new BufferedReader(new InputStreamReader(inStream));
			String line = null;
			while((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("종료합니다...");
	}
}
