package Object2;

public class charAt {
	public static void main(String[] args) {
		String str = new String("Java");
		System.out.println("���� ���ڿ� : " + str);
		
		for (int i = 0; i < str.length(); i++) {
			System.out.print(str.charAt(i) + " ");
		}
		System.out.println("\ncharAt() �޼ҵ� ȣ�� �� ���� ���ڿ� : " + str);
	}
}
