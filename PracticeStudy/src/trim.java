package Object2;

public class trim {
	public static void main(String[] args) {
		String str = new String("  Java		");
		System.out.println("���� ���ڿ� : " + str);
		
		System.out.println(str + '|');
		System.out.println(str.trim() + '|');
		System.out.println("trim() �޼ҵ� ȣ�� �� ���� ���ڿ� : " + str);
	}
}
