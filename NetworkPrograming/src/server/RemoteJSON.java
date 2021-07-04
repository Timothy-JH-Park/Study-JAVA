package server;


import java.net.*;
import java.io.*;
import com.google.gson.*;


public class RemoteJSON {

   public static void main(String[] args) throws Exception {
      String site = "https://jsonplaceholder.typicode.com/posts";
      URL url = new URL(site);
      
      URLConnection con = url.openConnection();
      
      InputStream stream = con.getInputStream();
      InputStreamReader reader = new InputStreamReader(stream);
      BufferedReader buffReader = new BufferedReader(reader);
      
      String line = null;
      while((line = buffReader.readLine()) != null) {
         System.out.println(line);
      }
      
      Gson gson = new Gson();
      Person person = gson.fromJson("{'name':'gdhon', 'age':10, 'graduated':false}",
                  Person.class);
      
      /* 
       * Person p = new Person();
       * p.setName("gdhon");
       * p.setAge(10);
       */
      
      System.out.println(person.getName());
      System.out.println(person.getAge());
      System.out.println(person.isGraduated());
      
      
      buffReader.close();

   }
}

class Person {
   // JavaBean ���·� Ŭ������ ����
   // 1. private member ������ ���� public getter�� setter�� ������.
   // 2. default �����ڸ� ������. 
   private String name;
   private int age;
   private boolean graduated;

   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public int getAge() {
      return age;
   }
   public void setAge(int age) {
      this.age = age;
   }
   public boolean isGraduated() {
      return graduated;
   }
   public void setGraduated(boolean graduated) {
      this.graduated = graduated;
   }
   
   
}