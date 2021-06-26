package map;

import java.util.*;
public class MapTest2 {

	public static void main(String[] args) {
		String[] str = {"to", "be", "or", "not", "to", "be", "is", "a", "problem"};
		/*
		 	Map���ٰ� �ܾ Ű��, �� �ܾ ������ Ƚ���� ������ ����.
		 */
		
		// int ���� Integer�� ����ϴ� ����? 
		// generic�� Ÿ�� �Ķ���ͷδ� �⺻Ÿ���� ������� �ʴ´�.
		
		Map<String, Integer> map = new HashMap<>();
		
		// str �迭�� �����ҿ� ���ؼ�
		// �� ���Ҹ� Ű(key)�ΰ� ������ ��Ʈ���� ������ �˻�
		// 	1.���࿡ �׷��� ��Ʈ���� ������
		//		�ִٶ� ���� map.get(key) ��ȯ�Ǵ� ���� null�� �ƴ϶�� �ǹ�.
		//		int count = map.get(key);
		// Integer ���ε� int ������ �־ �ɱ�?
		// auto unboxing..
		// ��ü Ÿ���� ���� �����Ǵ� �⺻ Ÿ���� ������ �����϶�� �ϸ�
		// �ڹٴ� �ڵ����� �� ��üŸ���� ���� �⺻ Ÿ���� ������ ��ȯ.
		// 	2.�׷��� ��Ʈ���� ������
		// 		�� key�� �ش��ϴ� �ܾ�� ó�� ���� �Ŵ�. �׷�, map�� �߰��ϸ� �ȴ�.
		// 		map.put(key, 1); // �ڹٴ� auto boxing..
		//		-> �⺻ Ÿ�� ���� �����Ǵ� ��ü Ÿ�� ������ �ڵ���ȯ
		// {"to", "be", "or", "not", "to", "be", "is", "a", "problem"}
		// map : <"to", 1>, <"be", 1>, <"or", 1>, <"not", 1>,
		//
		
		for (String key : str) {
			Integer count = map.get(key);
			if (count != null) {
				map.put(key, count + 1);
			} else { // �� �ܾ�� ���� ó�� ���Դ�.
				map.put(key, 1);
			}
		}
	
	
	
	}
}
