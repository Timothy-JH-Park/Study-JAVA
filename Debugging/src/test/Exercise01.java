package test;

import java.util.Scanner;

public class Exercise01 {

	public static void main(String[] args) {
		while(true) {
			try {
				int val = getInput();
				switch(val) {
				
				case 1 :
				case 2 :
				case 3 :
				case 4 :
				case 5 :
					System.out.println("5 이하의 수 : " + val);
					
				case 6 :
				case 7 :
				case 8 :
				case 9 :
				case 10 :
					System.out.println("5 초과 10 이하의 수 : "+ val);
				default :
					System.out.println("1~10 사이의 값을 입력하시오");
			}
		} catch(Exception e) {
			System.out.println("일반 문자 말고 숫자!!");
		}
	}
}
		
		private static int getInput() {
			Scanner input = new Scanner(System.in);
//			String val = input.nextLine();
//			for (int i = 0; i < val.length; i++) {
//				if (val.charAt(i) > '0' || val.charAt(i) < '9')
//					return -1;
//			}
//			
//			return Integer.parseInt(val);
//			return val;
			
			System.out.println("1~10사이의 수를 입력하세요...");
			return input.nextInt();
		}
}
	

