
public class Money2 {

	public static void main(String[] args) {
		
		int s = 9, d = 7, r = 8, y = 2;
		int send, more, money;
		int count=0;
		
		//SEND+MORE=MONEY를 만족하는 프로그램을 작성하시게.
//		각각의 알파벳은 고유의 숫자를 뜻한다. 
//		힌트  
//		s = 9
//		d = 7
//		r = 8 
//		y = 2
//		m, e, n, o를 찾아야되는거네 
//		      
//		        		 SEND
//		                +MORE
//		      --------------------
//		                MONEY
//
//				         9EN7
//		                +MO8E
//		      --------------------
//		                MONE2
		
		for (int m = 1; m < 9; m++) {
			for (int e = 0; e < 9; e++) {
				for (int n = 0; n < 9; n++) {
					for (int o = 0; o < 9; o++) {
						
						int num1 = 1000*s + 100*e + 10*n + d;
						int num2 = 1000*m + 100*o + 10*r + e;
						int num3 = 10000*m + 1000*o + 100*n + 10*e + y;
						
						if(num1+num2==num3) {
							System.out.println("m = " + m);
							System.out.println("e = " + e);
							System.out.println("n = " + n);
							System.out.println("o = " + o);
							System.out.println("money = " + num3);
							count++;
						}
						
					}
				}
			}
			
		}
		
	}
}
