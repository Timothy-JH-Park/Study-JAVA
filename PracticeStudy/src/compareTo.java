package Object2;

public class compareTo {
	public static void main(String[] args) {
		String str = new String("abcd");
		System.out.println("���� ���ڿ� : " + str);
		
		System.out.println(str.compareTo("bcef"));
		System.out.println(str.compareTo("abcd"));
		
		System.out.println(str.compareTo("Abcd"));
		System.out.println(str.compareToIgnoreCase("Abcd"));
		System.out.println("compareTo() �޼ҵ� ȣ�� �� ���� ���ڿ� : " + str);
	}
}
