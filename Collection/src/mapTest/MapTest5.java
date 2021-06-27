package map;

import java.util.*;

public class MapTest5 {

	public static void main(String[] args) {
		
		/*
		 * 분발별 전화번호부 구현
		 * Map 타입의 phoneBook에 A반 전허번호부, B반 전화번호부를 저장
		 * A반, B반 전화번호부도 Map 타입.
		 * A반 전화번호부에는 A반 학생들의 전화번호가 <이름, 전화번호>의 쌍으로
		 * B반 전화번호부에는 B반 학생들의 전화번호가 <이름, 전화번호>의 쌍으로
		 * 저장됨.
		 */
		// A반 전화번호부<이름, 전화번호>의 쌍으로 저장되니
		Map<String, String> aBan = new TreeMap<>();
		aBan.put("박동현", "010-1111-2222");
		aBan.put("김정세", "010-1111-3333");
		aBan.put("장재현", "010-1111-4444");
		
		Map<String, String> bBan = new TreeMap<>();
		
		bBan.put("구나현", "010-2222-1111");
		bBan.put("김새별", "010-2222-2222");
		bBan.put("한규민", "010-2222-3333");
		
		// <"A반", aBan>, <"B반", bBan>
		Map<String, Map<String, String>> phoneBook = new HashMap<>();
		
		phoneBook.put("A반", aBan);
		phoneBook.put("B반", bBan);
		
		Scanner input = new Scanner(System.in);
		while(true) {
			System.out.println("어느 반?(A반 또는 B반, 종료는 Q)");
			String ban = input.nextLine();
			
			if (ban.equalsIgnoreCase("Q")) break; 
			
			Map<String, String> banPB = phoneBook.get(ban);
			if (banPB == null) {
				System.out.println("그런 반은 없어요...");
				continue;
			
			}
			System.out.println("누구?");
			String who = input.nextLine();
			String phone = banPB.get(who);
			if (phone == null) {
				System.out.println("그런 학생은 없어요..");
				continue;
			}
			System.out.println(ban + "의" + who + ":" + phone);
					
		}
		input.close();
		System.out.println("프로그램을 종료합니다...");
	}
}
