package server;

import java.net.*; 
import java.io.*;

public class URLConnectionReader {

   public static void main(String[] args) throws Exception {
      // 1. URL 객체를 생성
      URL site = new URL("https://www.naver.com");
      
      // 2. 연결 설립
      
      URLConnection con = site.openConnection();
      
      // 3. 연결로부터 스트림을 얻어야 한다. 
      InputStream stream = con.getInputStream();
      
      InputStreamReader streamReader = new InputStreamReader(stream);
      
      BufferedReader reader = new BufferedReader(streamReader);
      String line;
      while((line = reader.readLine()) != null) {
         System.out.println(line);
      }
      System.out.println();
      
   }

}