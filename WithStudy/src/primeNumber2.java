
import java.util.*;

public class primeNumber2 {

	public static void main(String[] args) {
		
		System.out.println("입력");
		
		Scanner input = new Scanner(System.in);
		
		int num = input.nextInt();
		
		int sum = 0;
		
		
		for (int i = 2; i < num; i++) {
			
			int prime = 0;
			
			for (int j = 1; j <= i; j++) {
				if(i%j==0) {
					prime++;
				}
			}
			
			if(prime==2) {
				sum += i;
				System.out.print(i+",");
			}
			
		}
		System.out.println(num + "까지의 소수의 합은" + sum);
		
	}
	
}
