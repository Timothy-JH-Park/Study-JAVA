package collections;

import java.util.*;

public class CollectionAPITest {

	public static void main(String[] args) {
//		sortTest();
//		shuffleTest(); // ����
//		binarySearch();
		
		Integer arr[] = new Integer[7];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		List<Integer> list = Arrays.asList(arr);
		String[] str = {"a", "b", "c", "d", "e", "f", "g"};
		List<String> list2 = Arrays.asList(str);
		System.out.println(binarySearch2(list2, "b"));
		
	}
	
	public static void binarySearch() {
		
		// �� ������ ���� ���Ҹ� ���� ����Ʈ����
		// ���� ã���� �ϴ� ��(���� ��� 123)�� �ִ���, ��� �ִ�����
		// ã���� �Ѵ�. ��� �ؾ��ϳ�?
		// ���࿡, ����Ʈ�� ���Ұ� ���ĵǾ� �ִٸ�?
		// ������ ���ҿ��� ���� ���ϴ� �� ã�⸦ �� ��
		// �ִ� �� ���� �񱳸� �ؾ��ұ�?
		
		// ����Ž���� �ϱ� ���� ������ ������?
		// ����Ʈ�� ���Ұ� ���ĵǾ� �־�� �Ѵ�.
		
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= 10; i++)
			list.add(i);
		
		System.out.println(list);
		Collections.shuffle(list);
		Collections.sort(list);
		int idx = Collections.binarySearch(list, 7);
		if (idx >= 0)
			System.out.println((idx+1) + "�� ° ��ġ�� �ֽ��ϴ�.");
		else {
			System.out.println("7�� ����Ʈ�� �����ϴ�.");
		}
		
	}
	
//	public static <T extends Comparable<T>>int binarySearch2(List<T> list, T key) {
	public static <T> int binarySearch2(List<? extends Comparable<T>> list, T key) {
		int left = 0;
		int right = list.size() -1;
		
		// left�� right ������ ���� ������ �ݺ�
		
		/*
		  mid = (left + right) / 2
		  if (list.get(mid) == key) return mid;
		  else if (list.get(mid) > key) {
		   right = mid -1;
		  } else {
		   left = mid + 1;
		  }
		  
		 */
		
		while(left <= right) {
			int mid = (left + right) / 2;
			if (list.get(mid) == key) return mid;
			else if (list.get(mid) > key) {
				right = mid -1;
			} else {
				left = mid + 1;
			}			
			
		}
		
		return left*(-1); // �� ���� ���밪�� key�� �;ߵ� ��ġ.
	
	}
	
	
	public static void shuffleTest() {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 1; i <= 10; i++)
			list.add(i);
		
		System.out.println(list);
		
		System.out.println("After shuffling");
		Collections.shuffle(list);
		
		System.out.println(list);
		
		
	}
		
	
	
	public static void sortTest() {
		String[] sample = {"i", "walk", "The", "Line"};
		
		List<String> list = Arrays.asList(sample);
		Collections.sort(list);
		Collections.sort(list, 
				(o1, o2) -> o1.compareToIgnoreCase(o2));
		System.out.println(list);
		
	}
	
	
}
