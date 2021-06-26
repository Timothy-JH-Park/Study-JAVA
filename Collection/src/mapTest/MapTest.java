package map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class MapTest {

	public static void main(String[] args) {
		
		/*
		 	Map �������̽��̰� ����� ������ ����Ŭ������
		 	HashMap, TreeMap, LinkedHashMap 3���� �ִ�.
		 	�׷��� Map Ÿ���� ������ ���� 3�� Ÿ���� ��ü��
		 	������ �� �ִ�.
		 	Map�� ���� <key, value> ������ �����Ѵ�.
		 	Map�� Generic�̴�.
		 	Ŭ������ �޼ҵ� ���ο��� ����� ������ Ÿ���� ������ �ʰ�
		 	���� �� Ŭ������ ��ü�� ����ų� �޼ҵ带 ȣ���� ��
		 	����� ������ Ÿ���� �Ķ���ͷ� �޾Ƽ� ó���ϴ� ��.
		 	���ڿ� Ÿ���� �й��� Ű��, Student ��ü�� ������ Map�� ����.
		 */
		
		
		
		Map<String, Student> map = new HashMap<>();
		
		// Map�� ����(<key, value>�� ������ entry)�� ���� ����
		// put �޼ҵ带 ��� : put�޼ҵ�� ���� ���԰� ���濡 ��� ����.
		// Map���� ����(��Ʈ��)�� ���� ���� get(key) �޼ҵ带 ���.
		
		// key���� �޶�� �Ѵ�
		// �̹� �����ϴ� Ű ������ put�ϸ�
		// ���� ���Ҹ� replace�ϰ� �ȴ�.
		
		map.put("20201234", new Student(20201234, "ȫ�浿"));
		map.put("20201235", new Student(20201235, "������"));
		map.put("20201236", new Student(20201236, "������"));
		map.put("20201237", new Student(20201237, "�̸���"));
		map.put("20201238", new Student(20201238, "������"));
		
		// ���Ұ��� ���� ���� Ű ���� ��� �Ѵ�.
//		Student std = map.get("20201237");
//		System.out.println(std);
		
		// map ��ü���� �װ� ���� key �� �� ��..
		Set<String> keyset = map.keySet();
		// keyset�� �ִ� �� ���Ҹ� ���ؼ� map���� ���� �䱸�ϸ� �ȴ�.
		// �ֳ��ϸ� �� ���Ұ� map�� ����� ���� key�ϱ�..
		
		Iterator<String> iter = keyset.iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			Student std = map.get(key);
			System.out.println(std);
		}
		
		// Entry�� Set : <key, value> pair�� Set
		/*
		 	Map��ü���� entrySet �޼ҵ带 ȣ���ϸ�
		 	Map.Entry Ÿ�԰�ü�� ���Ҹ� ������ Set ��ü�� ��ȯ�ȴ�.
		 	
		 */
		
		// Set�� �� ���Ұ� Map.Entry ��ü, �ٵ� Map.Entry ��ü��
		// generic�̴�. Map.Entry<String, Student>
		
		Set<Map.Entry<String, Student>> entrySet = map.entrySet();

		Iterator<Map.Entry<String, Student>> iter2 = entrySet.iterator();
		while (iter2.hasNext()) {
			Map.Entry<String, Student> entry = iter2.next();
			String mykey = entry.getKey();
			Student mystd = entry.getValue();
			System.out.println("key : " + mykey + ", value : " + mystd);
		}
		
		for (Map.Entry<String, Student> entry : map.entrySet()) {
			String mykey = entry.getKey();
			Student mystd = entry.getValue();
			System.out.println("key : " + mykey + ", value : " + mystd);
			
		}
		
		
	}
}

class Student {
	int number;
	String name;
	
	@Override
	public String toString() {
		return "[number=" + number + ", name=" + name + "]";
	}



	public Student(int number, String name) {
		this.number = number;
		this.name = name;
		
	}
}
