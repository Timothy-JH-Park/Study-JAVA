
public class primeNumber3 {

	public static void main(String[] args) {
		int sum = 0;
		
		for (int num = 2; num <= 100; num++) {
			int count = 0;
			
			for (int i = 1; i <= num; i++) {
				if(num%i==0) {
					count++;
				}
			}
//			if(count==2) {
//				sum += num;
//				System.out.print(num+",");
//			}
		}
		System.out.println(sum);
	}
}
