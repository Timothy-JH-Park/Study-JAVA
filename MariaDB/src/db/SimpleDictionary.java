package db;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SimpleDictionary extends JPanel implements ActionListener{
   /*
    * 단어 입력 받을 수 있는 JTextField
    * 검색 버튼
    * 추가 버튼
    * 단어장 구현을 위한 자료구조로 Map 객체
    */
   private JTextField inputField = new JTextField(30);
   private JButton searchBtn = new JButton("검색");
   private JButton addBtn = new JButton("추가");
   
   private String server = "localhost:3307"; // MySQL 서버 주소
   private String database = "Timothy"; // MySQL DATABASE 이름
   private String user_name = "root"; //  MySQL 서버 아이디
   private String password = "1111"; // MySQL 서버 비밀번호
   
   // Map 객체를 단어장 구현 사용할꺼다. 
   // <key, value> 쌍으로 저장. key는 한글단어, value는 대응되는 영어단어.
   private Map<String, String> dict = new HashMap<>();
   public static final String driverClassName = "org.mariadb.jdbc.Driver";
   
   public SimpleDictionary() {
      // Panel의 기본 레이아웃은 : FlowLayout
      this.add(inputField);
      this.add(searchBtn);
      this.add(addBtn);
      
      // searchBtn, addBtn에 클릭 이벤트가 발생했을 때 처리할 리스너를 지정하자!
      searchBtn.addActionListener(this);
      addBtn.addActionListener(this);
      
      this.setPreferredSize(new Dimension(600, 50));
      
      // 파일에 key=value 형태로 저장된 엔트리들을 읽어서, dict를 구성하자.
      // DB에서 레코드를 읽고, 그 레코드들을 이용해 dict 맵을 구성하자.
      buildDictionaryFromDB();
   }
   
   private void buildDictionaryFromDB() {
      /* 1. Database 연결 
       *    a. JDBC Driver를 로딩.
       * 2. SELECT 문 수행
       * 3. SELECT 문의 수행으로 반환된 레코드들을 이용해
       *    dict Map 객체를 구성
       * 4. Database 연결 해제.
       */
	 
       
       
	// 2.연결
       try (Connection con = DriverManager.getConnection("jdbc:mariadb://" + server + "/" + database + "?useSSL=false", user_name, password)) {
           System.out.println("정상적으로 연결되었습니다.");
           String sql = "SELECT * FROM dict";
           PreparedStatement pstmt = con.prepareStatement(sql);
           // Insert, Update, Delete
           // executeUpdate()
           // select
           // executeQuery()
           ResultSet resultSet = pstmt.executeQuery();
           while (resultSet.next()) {
               String key = resultSet.getString("kor");
               String value = resultSet.getString("eng");
               dict.put(key, value);
               dict.put(value, key);
               System.out.println(key + ":" + value);
           }
       } catch (SQLException e) {
           System.err.println("con 오류:" + e.getMessage());
           e.printStackTrace();
       }
	   
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      String key = inputField.getText();
      if (key.trim().length() == 0) // 공백만 입력된 경우는 무시. 
         return;
      
      if (e.getSource() == searchBtn) {
         /*
          * 입력된 단어를 추출
          * 그 단어를 key 값으로 가지는 대응되는 맵 엔트리가 있는지 검사 -> dict.get(단어);
          * 그 단어에 대응되는 값이 있으면 JOptionPane.showMessageDialog() 메서드를
          * 호출해서 그 대응되는 값을 보여준다.
          * 없으면 (null이면) JOptionPane.showMessageDialog() 메서드를 호출해서 
          * '단어를 찾을 수 없습니다'라고 출력해준다. 
          * inputField를 빈 문자열로 설정.
          */
         System.out.println("[" + key + "]");
         String value = dict.get(key);
         if (value != null) { // 대응되는 단어가 있는 경우
            JOptionPane.showMessageDialog(this, value, key, 
                           JOptionPane.INFORMATION_MESSAGE);   
         } else { // 대응되는 단어가 없는 경우
            JOptionPane.showMessageDialog(this, "단어를 찾을 수 없습니다", key, 
                              JOptionPane.ERROR_MESSAGE);
         }
      } else if (e.getSource() == addBtn) {
         /*
          * 입력된 단어를 추출
          * String value = JOptionPane.showInputDialog(); 
          *    메서드를 호출해서 추가할 영어 단어를 입력 받는다.
          *  dict.put(입력필드에 입력된 단어, inputDialog에 입력된 단어);
          *    inputField를 빈 문자열로 설정.
          */
         String value = JOptionPane.showInputDialog(this, 
                           key + "에 대응되는 영어단어를 입력하세요");
         if (value.trim().length() == 0) return;
         dict.put(key, value);
         // 파일에도 key=value 의 쌍으로 기록해놓자. 
         // DB에 <key, value>의 쌍을 하나의 레코드로 저장하자.
         addToDB(key, value);
         JOptionPane.showMessageDialog(this, "["+value+"] 영어단어가 추가되었습니다", 
                     key, JOptionPane.INFORMATION_MESSAGE);
      }
//      inputField.setText("");
   }
   
   private void addToDB(String key, String value) {
      
      /* 드라이버를 메모리에 적재한다. <- 메모리 적재는 한 번만 하면 되고
       * 이미 생성자에서 했다.
       * DB에 연결해서 Connection 객체를 반환받는다.
       * Connection 객체에게 preparedStatement 객체를 요청한다.
       * PreparedStatement 객체의 executeUpdate() 메서드를
       * 호출해서 DB에 저정한다.
       */
	   
	   try(Connection con =
			DriverManager.getConnection("jdbc:mariadb://" + server + "/" + database + "?useSSL=false", user_name, password)) {
		   String sql = "insert into dict values(?, ?)";
		   
		   
		   PreparedStatement pstmt = con.prepareStatement(sql);
		   
		   pstmt.setString(1, key);
		   pstmt.setString(2, value);
		   // Insert, Delete, Update 문을 실행할 때는 executeUpdate() 메소드를 호출한다.
		   pstmt.executeUpdate();
		   
	   } catch(SQLException e) {
		   System.out.println(e.getMessage());
		   e.printStackTrace();
	   }
	   
	   
	   
   }
   
   public static void main(String[] args) {
      JFrame frame = new JFrame();
      SimpleDictionary dictPanel = new SimpleDictionary();
      frame.add(dictPanel);
      frame.setTitle("나의 한영사전");
      
      frame.setResizable(false);
      frame.pack();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}