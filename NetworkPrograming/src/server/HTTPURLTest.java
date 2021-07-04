package server;

import java.net.*;
import java.io.*;

public class HTTPURLTest {
   public static void main(String[] args) throws Exception {
      String site = "https://www.google.com/search?q=java&ie=UTF-8";
      URL url = new URL(site);
      HttpURLConnection con = (HttpURLConnection)url.openConnection();
//      URLConnection con = url.openConnection();
      con.setRequestMethod("GET");
      con.setRequestProperty("User-Agent", "Mozilla/5.0");
      
      int code = con.getResponseCode();
      System.out.println("Response code:" + code);
      // 연결로부터 스트림을 얻어야 한다. 
      InputStream stream = con.getInputStream();
      
      InputStreamReader streamReader = new InputStreamReader(stream, "UTF-8");
      
      BufferedReader reader = new BufferedReader(streamReader);
      String line;
      while((line = reader.readLine()) != null) {
         System.out.println(line);
      }
      System.out.println();
      
   }
}
