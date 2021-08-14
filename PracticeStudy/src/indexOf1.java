package Object2;

public class indexOf1 {
	public static void main(String[] args) {
		String str = new String("Oracle Java");
		System.out.println("원본 문자열 : " + str);
		
		System.out.println(str.indexOf('o'));
		System.out.println(str.indexOf('a'));
		System.out.println(str.indexOf("Java"));
		System.out.println("indexOf() 메소드 호출 후 원본 문자열 : " + str);
	}
}