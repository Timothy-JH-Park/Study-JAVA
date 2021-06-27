package map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.*;

public class MapTest6 {

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
		Map<String, Map<String, String>> phoneBook = new TreeMap<>();
		
		phoneBook.put("A반", aBan);
		phoneBook.put("B반", bBan);
		
		Set<Map.Entry<String, Map<String, String>>> entrySet
								= phoneBook.entrySet();
		
		Iterator<Map.Entry<String, Map<String, String>>> iter1
								= entrySet.iterator();
		
		while(iter1.hasNext()) {
			Map.Entry<String, Map<String, String>> entry = iter1.next();
			System.out.println(entry.getKey()); // A반 또는 B반
			// A반 또는 B반의 전화번호부
			Map<String, String> pb = entry.getValue();
			
			// A반 또는 B반 전화번호부의 엔트리 집합,
			// 즉, Map.Entry<이름, 전화번호> 타입의 객체를 원소로 가지는 집합
			
			Set<Map.Entry<String, String>> phones = pb.entrySet();
			// <이름, 전화번호>의 쌍을 하나의 원소로 가지는 집합의 각 원소에 접근
			Iterator<Map.Entry<String, String>> iter2 = phones.iterator();
			
			while(iter2.hasNext()) {
				// <이름, 전화번호>의 엔트리를 추출
				Map.Entry<String, String> phone = iter2.next();
				// 이름, 전화번호를 출력
				System.out.println(phone.getKey() + " : " + phone.getValue());
				
			}
			System.out.println("\n");
			
		}
		//위와 동일한 기능을 Map의 keySet을 이용해 구현해서 github에 업로드 하시오.
		
		
		
		
//		Scanner input = new Scanner(System.in);
//		while(true) {
//			System.out.println("어느 반?(A반 또는 B반, 종료는 Q)");
//			String ban = input.nextLine();
//			
//			if (ban.equalsIgnoreCase("Q")) break; 
//			
//			Map<String, String> banPB = phoneBook.get(ban);
//			if (banPB == null) {
//				System.out.println("그런 반은 없어요...");
//				continue;
//			
//			}
//			System.out.println("누구?");
//			String who = input.nextLine();
//			String phone = banPB.get(who);
//			if (phone == null) {
//				System.out.println("그런 학생은 없어요..");
//				continue;
//			}
//			System.out.println(ban + "의" + who + ":" + phone);
//					
//		}
//		input.close();
//		System.out.println("프로그램을 종료합니다...");
	}
}
