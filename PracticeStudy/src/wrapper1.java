package Object2;

public class wrapper1 {
	public static void main(String[] args) {
		Integer num = new Integer(17);	// �ڽ�
		int n = num.intValue();			// ��ڽ�
		System.out.println(n);
				
		Character ch = 'X';		// Character ch = new Character('X'); : ����ڽ�
		char c = ch;			// char c = ch.charValue();           : �����ڽ�
		System.out.println(c);
	}
}
