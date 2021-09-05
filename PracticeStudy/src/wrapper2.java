package Object2;

public class wrapper2 {
	public static void main(String[] args) {
		Integer num1 = new Integer(7);	// 冠教
		Integer num2 = new Integer(3);	// 冠教

		int int1 = num1.intValue();		// 攫冠教
		int int2 = num2.intValue();		// 攫冠教

		Integer result1 = num1 + num2;
		System.out.println(result1);

		Integer result2 = int1 - int2;
		System.out.println(result2);

		int result3 = num1 * int2;
		System.out.println(result3);
	}
}
