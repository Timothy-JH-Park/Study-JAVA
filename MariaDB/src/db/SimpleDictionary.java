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
    * �ܾ� �Է� ���� �� �ִ� JTextField
    * �˻� ��ư
    * �߰� ��ư
    * �ܾ��� ������ ���� �ڷᱸ���� Map ��ü
    */
   private JTextField inputField = new JTextField(30);
   private JButton searchBtn = new JButton("�˻�");
   private JButton addBtn = new JButton("�߰�");
   
   private String server = "localhost:3307"; // MySQL ���� �ּ�
   private String database = "Timothy"; // MySQL DATABASE �̸�
   private String user_name = "root"; //  MySQL ���� ���̵�
   private String password = "1111"; // MySQL ���� ��й�ȣ
   
   // Map ��ü�� �ܾ��� ���� ����Ҳ���. 
   // <key, value> ������ ����. key�� �ѱ۴ܾ�, value�� �����Ǵ� ����ܾ�.
   private Map<String, String> dict = new HashMap<>();
   public static final String driverClassName = "org.mariadb.jdbc.Driver";
   
   public SimpleDictionary() {
      // Panel�� �⺻ ���̾ƿ��� : FlowLayout
      this.add(inputField);
      this.add(searchBtn);
      this.add(addBtn);
      
      // searchBtn, addBtn�� Ŭ�� �̺�Ʈ�� �߻����� �� ó���� �����ʸ� ��������!
      searchBtn.addActionListener(this);
      addBtn.addActionListener(this);
      
      this.setPreferredSize(new Dimension(600, 50));
      
      // ���Ͽ� key=value ���·� ����� ��Ʈ������ �о, dict�� ��������.
      // DB���� ���ڵ带 �а�, �� ���ڵ���� �̿��� dict ���� ��������.
      buildDictionaryFromDB();
   }
   
   private void buildDictionaryFromDB() {
      /* 1. Database ���� 
       *    a. JDBC Driver�� �ε�.
       * 2. SELECT �� ����
       * 3. SELECT ���� �������� ��ȯ�� ���ڵ���� �̿���
       *    dict Map ��ü�� ����
       * 4. Database ���� ����.
       */
	 
       
       
	// 2.����
       try (Connection con = DriverManager.getConnection("jdbc:mariadb://" + server + "/" + database + "?useSSL=false", user_name, password)) {
           System.out.println("���������� ����Ǿ����ϴ�.");
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
           System.err.println("con ����:" + e.getMessage());
           e.printStackTrace();
       }
	   
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      String key = inputField.getText();
      if (key.trim().length() == 0) // ���鸸 �Էµ� ���� ����. 
         return;
      
      if (e.getSource() == searchBtn) {
         /*
          * �Էµ� �ܾ ����
          * �� �ܾ key ������ ������ �����Ǵ� �� ��Ʈ���� �ִ��� �˻� -> dict.get(�ܾ�);
          * �� �ܾ �����Ǵ� ���� ������ JOptionPane.showMessageDialog() �޼��带
          * ȣ���ؼ� �� �����Ǵ� ���� �����ش�.
          * ������ (null�̸�) JOptionPane.showMessageDialog() �޼��带 ȣ���ؼ� 
          * '�ܾ ã�� �� �����ϴ�'��� ������ش�. 
          * inputField�� �� ���ڿ��� ����.
          */
         System.out.println("[" + key + "]");
         String value = dict.get(key);
         if (value != null) { // �����Ǵ� �ܾ �ִ� ���
            JOptionPane.showMessageDialog(this, value, key, 
                           JOptionPane.INFORMATION_MESSAGE);   
         } else { // �����Ǵ� �ܾ ���� ���
            JOptionPane.showMessageDialog(this, "�ܾ ã�� �� �����ϴ�", key, 
                              JOptionPane.ERROR_MESSAGE);
         }
      } else if (e.getSource() == addBtn) {
         /*
          * �Էµ� �ܾ ����
          * String value = JOptionPane.showInputDialog(); 
          *    �޼��带 ȣ���ؼ� �߰��� ���� �ܾ �Է� �޴´�.
          *  dict.put(�Է��ʵ忡 �Էµ� �ܾ�, inputDialog�� �Էµ� �ܾ�);
          *    inputField�� �� ���ڿ��� ����.
          */
         String value = JOptionPane.showInputDialog(this, 
                           key + "�� �����Ǵ� ����ܾ �Է��ϼ���");
         if (value.trim().length() == 0) return;
         dict.put(key, value);
         // ���Ͽ��� key=value �� ������ ����س���. 
         // DB�� <key, value>�� ���� �ϳ��� ���ڵ�� ��������.
         addToDB(key, value);
         JOptionPane.showMessageDialog(this, "["+value+"] ����ܾ �߰��Ǿ����ϴ�", 
                     key, JOptionPane.INFORMATION_MESSAGE);
      }
//      inputField.setText("");
   }
   
   private void addToDB(String key, String value) {
      
      /* ����̹��� �޸𸮿� �����Ѵ�. <- �޸� ����� �� ���� �ϸ� �ǰ�
       * �̹� �����ڿ��� �ߴ�.
       * DB�� �����ؼ� Connection ��ü�� ��ȯ�޴´�.
       * Connection ��ü���� preparedStatement ��ü�� ��û�Ѵ�.
       * PreparedStatement ��ü�� executeUpdate() �޼��带
       * ȣ���ؼ� DB�� �����Ѵ�.
       */
	   
	   try(Connection con =
			DriverManager.getConnection("jdbc:mariadb://" + server + "/" + database + "?useSSL=false", user_name, password)) {
		   String sql = "insert into dict values(?, ?)";
		   
		   
		   PreparedStatement pstmt = con.prepareStatement(sql);
		   
		   pstmt.setString(1, key);
		   pstmt.setString(2, value);
		   // Insert, Delete, Update ���� ������ ���� executeUpdate() �޼ҵ带 ȣ���Ѵ�.
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
      frame.setTitle("���� �ѿ�����");
      
      frame.setResizable(false);
      frame.pack();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}