
import java.util.*;

public class PrimeNumber {

	public static void main(String[] args) {
		
		System.out.println("�Է��ϼ���");
		Scanner input = new Scanner(System.in);
		
		int num = 0;
		num = input.nextInt();
		
		boolean isPrime = false;
		
		int sum = 0;
		
		for(int i=1; i<=num; i++) {
			if(num%i==0) {
				isPrime = true;
				System.out.println("�Ҽ�" + i);
				sum = sum + i;
				
			} else {
				System.out.println(i + "�� �Ҽ��� �ƴմϴ�");
			}
		}
		
	}
	
}
