package Object2;

public class append1 {
	public static void main(String[] args) {
		StringBuffer str = new StringBuffer("Java");
		System.out.println("원본 문자열 : " + str);

		System.out.println(str.append("수업"));
		System.out.println("append() 메소드 호출 후 원본 문자열 : " + str);
	}
}
