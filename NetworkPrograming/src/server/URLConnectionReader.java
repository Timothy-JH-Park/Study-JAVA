package server;

import java.net.*; 
import java.io.*;

public class URLConnectionReader {

   public static void main(String[] args) throws Exception {
      // 1. URL ��ü�� ����
      URL site = new URL("https://www.naver.com");
      
      // 2. ���� ����
      
      URLConnection con = site.openConnection();
      
      // 3. ����κ��� ��Ʈ���� ���� �Ѵ�. 
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