package linkedList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class SetTest2 {
	
	class MyComparator<Integer> implements Comparator<Integer> {
	
		@Override
		public int compare(Integer o1, Integer o2) {
			
//			return (o1.intValue() - o2.intValue()) * -1;
			return (-1) * (o1.intValue() - o2.intValue());
		}
	}

	public static void main(String[] args) {
//		test1();
		testPriorityQueue();
	}

	private static void testPriorityQueue() {
		Queue<Integer> queue 
		= new PriorityQueue<>(new Comparator<Integer>());
		for (int i = 10; i > 0; i--) queue.offer(i);
		
		System.out.println(queue);
			
		for (Integer n : queue) System.out.println(n + " ");
		
		System.out.println();
		int length = queue.size();
		for (int i = 0; i <queue.size(); i++) {
			System.out.println((i+1)+"��° ���� : "+queue.poll());
		}
 	}
	
	
	
	
	public static void test1() {
		/*
		 ������: addAll()
		 ������: retainAll()
		 ������: removeAll()
		 */
		/*
			set1 : {1, 3, 4, 5, 7, 9, 10}
			set2 : {2, 4, 10}
			set1 U set2 {1, 2, 3, 4, 5, 7, 9, 10}
			set1 interection set2 : {4, 10}
			set1 - set2 : {1, 3, 5, 7, 9}
		 */
		
		Integer[] arr1 = {1, 3, 4, 5, 7, 9, 10};
		List<Integer> list = Arrays.asList(arr1);
		Set<Integer> set1 = new HashSet<>(list);
		
		Integer[] arr2 = {2, 4, 10};
		List<Integer> list2 = Arrays.asList(arr2);
		Set<Integer> set2 = new HashSet<>(list2);
		
		//������

		//set1.addAll(set2); //���� �����Ͱ� �����
		Set<Integer> unionSet = new HashSet<>(set1);
		unionSet.addAll(set2);
		System.out.println("������" + unionSet);
		
		//������
		Set<Integer> intersectionSet = new HashSet<>(set1);
		intersectionSet.retainAll(set2);
		System.out.println("������" + intersectionSet);
		
		//������
		Set<Integer> diffSet = new HashSet<>(set1);
		diffSet.removeAll(set2);
		System.out.println("������" + intersectionSet);
		
//		set1.containsAll(set2);
		
		boolean flag = set1.containsAll(set2);
		if (flag) {
			System.out.printf("���� %s�� "
					+ "���� %s�� ��� ���Ҹ� �����մϴ�", set1, set2);
			
		} else {
			System.out.printf("���� %s�� "
					+ "���� %s�� ��� ���Ҹ� �������� �ʽ��ϴ�",
					set1, set2);
		}
		
		
	}
	
	
}
