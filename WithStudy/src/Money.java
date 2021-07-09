
public class Money {

	public static void main(String[] args) {
		int s = 9;
		int d = 7;
		int r = 8;
		int y = 2;
		
		int m, e, n, o;
		
		
		
		for (e = 0; e < 10; e++) {
			if((d+e)%10==2)
			{
				System.out.println("e = " + e);
				break;
			}
			for (n = 0; n < 10; n++) {
				if(((n+1)+r)%10==e) 
				{
					System.out.println("n = " + n);
					break;
				}
			}
			for (o = 0; o < args.length; o++) {
				if(((e+1)+o)%10==n) {
					System.out.println(o);
					break;
				}
			}
				
			
		}
		
		
		
//		if((7+e)%10==2) {
//			System.out.println(e);
//		}
		
	}
}
