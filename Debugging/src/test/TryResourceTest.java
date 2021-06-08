package test;

import java.io.*;

public class TryResourceTest {

	
	public static void main(String[] args) {
		writeList();
	}
	
	public static void writeList() {
		PrintWriter out = null;
		
//		try {
//			out = new PrintWriter("outfile.txt");
//			for (int i = 0; i < 10; i++) {
//				out.println("�迭 ��� " + i + "=" + i);
//			}
//			
//		} catch (FileNotFoundException e) {
//			//System.out.println(e.getMessage());
//			e.printStackTrace();
//		} finally {
//			if (out != null)
//				out.close();
//			System.out.println("������ �ݾҽ��ϴ�...");
//			//exception�� �߻��ϴ� �� �ϴ� ��������
//		}
		
//		try (PrintWriter out1 = new PrintWriter("outfile.txt")) {
//			for (int i = 0; i < 10; i++) {
//				out1.println("�迭 ��� " + i + "=" + i);
//			}
//		} catch (FileNotFoundException e) {
//				//System.out.println(e.getMessage());
//				e.printStackTrace();
//		}
		
		try (MyResource rc = new MyResource()) {
			System.out.println(rc.getValue());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
