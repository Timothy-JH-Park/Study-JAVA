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
		 * �йߺ� ��ȭ��ȣ�� ����
		 * Map Ÿ���� phoneBook�� A�� �����ȣ��, B�� ��ȭ��ȣ�θ� ����
		 * A��, B�� ��ȭ��ȣ�ε� Map Ÿ��.
		 * A�� ��ȭ��ȣ�ο��� A�� �л����� ��ȭ��ȣ�� <�̸�, ��ȭ��ȣ>�� ������
		 * B�� ��ȭ��ȣ�ο��� B�� �л����� ��ȭ��ȣ�� <�̸�, ��ȭ��ȣ>�� ������
		 * �����.
		 */
		// A�� ��ȭ��ȣ��<�̸�, ��ȭ��ȣ>�� ������ ����Ǵ�
		Map<String, String> aBan = new TreeMap<>();
		aBan.put("�ڵ���", "010-1111-2222");
		aBan.put("������", "010-1111-3333");
		aBan.put("������", "010-1111-4444");
		
		Map<String, String> bBan = new TreeMap<>();
		
		bBan.put("������", "010-2222-1111");
		bBan.put("�����", "010-2222-2222");
		bBan.put("�ѱԹ�", "010-2222-3333");
		
		// <"A��", aBan>, <"B��", bBan>
		Map<String, Map<String, String>> phoneBook = new TreeMap<>();
		
		phoneBook.put("A��", aBan);
		phoneBook.put("B��", bBan);
		
		Set<Map.Entry<String, Map<String, String>>> entrySet
								= phoneBook.entrySet();
		
		Iterator<Map.Entry<String, Map<String, String>>> iter1
								= entrySet.iterator();
		
		while(iter1.hasNext()) {
			Map.Entry<String, Map<String, String>> entry = iter1.next();
			System.out.println(entry.getKey()); // A�� �Ǵ� B��
			// A�� �Ǵ� B���� ��ȭ��ȣ��
			Map<String, String> pb = entry.getValue();
			
			// A�� �Ǵ� B�� ��ȭ��ȣ���� ��Ʈ�� ����,
			// ��, Map.Entry<�̸�, ��ȭ��ȣ> Ÿ���� ��ü�� ���ҷ� ������ ����
			
			Set<Map.Entry<String, String>> phones = pb.entrySet();
			// <�̸�, ��ȭ��ȣ>�� ���� �ϳ��� ���ҷ� ������ ������ �� ���ҿ� ����
			Iterator<Map.Entry<String, String>> iter2 = phones.iterator();
			
			while(iter2.hasNext()) {
				// <�̸�, ��ȭ��ȣ>�� ��Ʈ���� ����
				Map.Entry<String, String> phone = iter2.next();
				// �̸�, ��ȭ��ȣ�� ���
				System.out.println(phone.getKey() + " : " + phone.getValue());
				
			}
			System.out.println("\n");
			
		}
		//���� ������ ����� Map�� keySet�� �̿��� �����ؼ� github�� ���ε� �Ͻÿ�.
		
		
		
		
//		Scanner input = new Scanner(System.in);
//		while(true) {
//			System.out.println("��� ��?(A�� �Ǵ� B��, ����� Q)");
//			String ban = input.nextLine();
//			
//			if (ban.equalsIgnoreCase("Q")) break; 
//			
//			Map<String, String> banPB = phoneBook.get(ban);
//			if (banPB == null) {
//				System.out.println("�׷� ���� �����...");
//				continue;
//			
//			}
//			System.out.println("����?");
//			String who = input.nextLine();
//			String phone = banPB.get(who);
//			if (phone == null) {
//				System.out.println("�׷� �л��� �����..");
//				continue;
//			}
//			System.out.println(ban + "��" + who + ":" + phone);
//					
//		}
//		input.close();
//		System.out.println("���α׷��� �����մϴ�...");
	}
}
