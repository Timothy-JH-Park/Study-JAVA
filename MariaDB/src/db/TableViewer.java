package db;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TableViewer extends JFrame implements ActionListener{
   private JTextField idField, titleField, publisherField, yearField, priceField;
   private JButton previousBtn, nextBtn, insertBtn, finishBtn;
   private ResultSet rs = null;
   private Connection con = null;

   public TableViewer() {
      /* TableViewer 객체가 생성될 때, DB의 books 테이블의
       * 레코드들을 읽어 온다.
       * 1. 데이터베이스와 연결
       * 2. select 문 실행하고 반환된 ResultSet 객체를 가지고 있어야 함. 
       */
      try {
         Class.forName("org.mariadb.jdbc.Driver");
         con = DriverManager.getConnection("jdbc:mariadb://localhost:3307/timothy", "root", "1111");
         String sql = "select * from books order by book_id desc";
         PreparedStatement pstmt = con.prepareStatement(sql);
         rs  = pstmt.executeQuery();
      } catch(Exception e) {
         System.out.println(e.getMessage());
         System.out.println("DB 연결에 문제가 있어 프로그램을 종료합니다.");
         System.exit(0);
      }
      
      
      // 각 컴포넌트를 frame에 추가하기
      this.setLayout(new GridLayout(0, 2));
      this.add(new JLabel("ID", JLabel.CENTER));
      idField = new JTextField(10);
      this.add(idField);
      
      this.add(new JLabel("Title", JLabel.CENTER));
      titleField = new JTextField(10);
      this.add(titleField);
   
      this.add(new JLabel("Publisher", JLabel.CENTER));
      publisherField = new JTextField(10);
      this.add(publisherField);
      
      this.add(new JLabel("Year", JLabel.CENTER));
      yearField = new JTextField(10);
      this.add(yearField);
      
      this.add(new JLabel("Price", JLabel.CENTER));
      priceField = new JTextField(10);
      this.add(priceField);
      
      previousBtn = new JButton("Previous");
      previousBtn.addActionListener(this);
      this.add(previousBtn);
      
      nextBtn = new JButton("Next");
      nextBtn.addActionListener(this);
      this.add(nextBtn);

      insertBtn = new JButton("Insert");
      insertBtn.addActionListener(this);
      this.add(insertBtn);
      
      finishBtn = new JButton("Finish");
      finishBtn.addActionListener(this);
      this.add(finishBtn);

      this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
      this.setResizable(false);
      this.setSize(350, 200);
      this.setVisible(true);
      

   }
   public static void main(String[] args) {
      new TableViewer();

   }

   @Override
   public void actionPerformed(ActionEvent e) {
      try {
         if (e.getSource() == nextBtn  || 
                  e.getSource() == previousBtn) {
            if (e.getSource() == nextBtn) {
               rs.next();
            } else if (e.getSource() == previousBtn) {
               rs.previous();
            }
            
            /* 현재 레코드의 칼럼값을 읽어와, 
             * JTextField의 값으로 설정한다. 
             * idField, titleField, publisherField, 
             * yearField, priceField
             */
            int bookId = rs.getInt("book_id");
            idField.setText(String.valueOf(bookId));
            String title = rs.getString("title");
            titleField.setText(title);
            String publisher = rs.getString("publisher");
            publisherField.setText(publisher);
            Date year = rs.getDate("year"); // java.sql.Date
            yearField.setText(year.toString());
            int price = rs.getInt("price");
            priceField.setText(String.valueOf(price));
         } else if (e.getSource() == insertBtn) {
        	 // 이미 db 연결은 되어있고..
        	 // 이미 연결 정보를 가지고 있는 Connection 객체를
        	 // insert 문을 이용해 prepare하고
        	 // 반환된 PreparedStatement 객체를 이용해서
        	 // 실행요청을 서버에 보낸다.
        	 
//        	 String sql0 = "insert into books(title, publisher, year, price) VALUES('" +
//        	 titleField.getText() + "', '" + publisherField.getText() +"''")";

        	 String sql = "insert into books(title, publisher, year, price) VALUES(?, ?, ?, ?)";
        	 PreparedStatement pstmt = con.prepareStatement(sql);
        	 
        	 // ? 자리에 들어갈 값을 설정을 먼저 한 후에, 실행 요청을 서버에 보내야 한다.
        	 // ? 자리에 값을 설정할 때, 대응되는 칼럼의 데이터 타입에 따라 적절한 setXXX 메서드를 호출해야 한다.
        	 // 예를 들어, ?에 대응되는 칼럼이 title이고, 그 칼럼의 데이터 타입이 varchar이면 setString
        	 // ?에 대응되는 칼럼이 price이고, 그 칼럼의 데이터 타입이 int이면 setInt 메서드를 호출...
        	 
        	 String title = titleField.getText();
        	 pstmt.setString(1, title);
        	 
        	 String publisher = publisherField.getText();
        	 pstmt.setString(2, publisher);
        	 
        	 String year = yearField.getText();
//        	 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
//        	
//        	 // import java.sql.*;
//        	 // Date Date = new Date(date.getTime());
//        	 
//        	 
//        	 // 문자열을 parsing해서 java.util.Date 객체를 생성.
//        	 java.util.Date date = sdf.parse(year);
//        	 
//        	 // java.util.Date 객체로부터 java.sql.Date 객체 생성.
//        	 Date sqlDate = new Date(date.getTime());        	 
//        	 
//        	 // java.sql.Date 객체 값을 3 번 째 ? 자리에 설정
//        	 pstmt.setDate(3, sqlDate);
        	 
        	 pstmt.setDate(3, Date.valueOf(year));
        	 
        	 String price = priceField.getText();
        	 pstmt.setInt(4, Integer.valueOf(price));
        	 
        	 // 실행할 SQL문이 select 문인 경우에는 executeQuery 메서드를 호출
        	 // 실행할 SQL문이 insert, delete, 또는 update일 경우에,
        	 // executeUpdate 메서드를 호출
        	 pstmt.executeUpdate();
        	 JOptionPane.showMessageDialog(this, "등록성공!");
        	 reloading();
         } else if (e.getSource() == finishBtn) {
        	 System.out.println("프로그램을 종료합니다...데헷");
        	 con.close();
        	 this.dispose();
        	 System.exit(0);
         }

      } catch(Exception err) {
    	 JOptionPane.showMessageDialog(this, "오류 발생["+err.getMessage()+"]");
         System.out.println(err.getMessage());
      }
      
   }
   private void reloading() throws Exception {
	   String sql = "select * from books order by book_id desc";
       PreparedStatement pstmt = con.prepareStatement(sql);
       rs.close();
       rs  = pstmt.executeQuery();
   }

}
