import java.util.Random;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	twoDimensionalArray();
	//	twoDimensionalArray2();
		practice5();
	}
	private static void practice5() {
		
		int[] nums = {1,2,3,4,5,6,7,8,9};
		
//		for(int n = 0; n < nums.length; n++)
		for (int n : nums)
			
			System.out.print(n + " ");
	} 
	{
		
	}

	private static void twoDimensionalArray2() {
		int[] nums = {1, 2, 3, 4, 5 };
		int[][] jarr = { { 1, 2, 3, 4, 5 }, { 10, 20, 30, 40, 50 }, 
				{ 100, 200, 300, 400, 500 } };
//		new int [3][5];
		
		for (int i = 0; i < jarr.length; i++) {
//			System.out.println(jarr[i]);
			for (int j = 0; j < jarr[i].length; j++) {
				System.out.println(jarr[i][j] + " ");
			}
			System.out.println();
		}
		
		
		
		
		}
	
	
	
	
	
	
	
	
	private static void twoDimensionalArray() {
		int[][] ja = new int[2][10];
		int[] nums = new int[10];
		
//		System.out.println(ja.length);
//		System.out.println(ja[0].length);
		
		Random random = new Random();
		
		for (int i = 0; i < ja.length; i++) {
			
			//System.out.print("[" + i + "]: ");
			for(int j = 0; j < ja[i].length; j++) {
				
			//	System.out.print(j + " ");
				ja[i][j] = random.nextInt(100) + 1;
			}
			//System.out.println();
		}
		for (int i = 0; i < ja.length; i++) {
			
			//System.out.print("[" + i + "]: ");
			for(int j = 0; j < ja[i].length; j++) {
				
				System.out.print(ja[i][j] + " ");
			}
				
			System.out.println();
		}
		
		
		
		
		
		
		
	}
}
