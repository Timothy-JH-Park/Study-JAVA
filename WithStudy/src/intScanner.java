
import java.util.*;

public class intScanner {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int[] a = new int[5];
		
		for (int i = 0; i < a.length; i++) {
			System.out.print(i+1 + "번째 정수를 입력하세요 : ");
			
			a[i] = input.nextInt();
		}
				
		for (int i = 0; i < a.length; i++) {
			System.out.print(i+1 + "번째 " + a[i]++ + " " 
					+ a[i]-- + " " + ++a[i] + " " + --a[i]); 	 
			System.out.println();
		}
		
	}
}
