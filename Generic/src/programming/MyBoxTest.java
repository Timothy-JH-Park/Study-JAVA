package programming;

import javax.swing.*;

public class MyBoxTest {
	
	public static void main(String[] args) {
		MyBox box1 = new MyBox();
		box1.setValue("ȫ�浿");
		box1.setValue(100);
		box1.setValue(123.4);
		box1.setValue(new JFrame());
		openBox(box1);
	
//		print(Integer.valueOf(100));
	}
	
	private static void print(int val) {
		System.out.println(val);
	}
	
	private static void openBox(MyBox box) {
//		Object obj = box.getValue();
		Double d = (Double)box.getValue();
		System.out.println(d);
	}
	
	
}
