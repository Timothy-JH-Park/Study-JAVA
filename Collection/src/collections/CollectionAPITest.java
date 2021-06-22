package collections;

import java.util.*;

public class CollectionAPITest {

	public static void main(String[] args) {
//		sortTest();
//		shuffleTest(); // 섞기
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
		
		// 수 만개의 정수 원소를 가진 리스트에서
		// 내가 찾고자 하는 값(예를 들면 123)이 있는지, 어디에 있는지를
		// 찾고자 한다. 어떻게 해야하나?
		// 만약에, 리스트의 원소가 정렬되어 있다면?
		// 만개의 원소에서 내가 원하는 값 찾기를 할 때
		// 최대 몇 번의 비교를 해야할까?
		
		// 이진탐색을 하기 위한 대전제 조건은?
		// 리스트의 원소가 정렬되어 있어야 한다.
		
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= 10; i++)
			list.add(i);
		
		System.out.println(list);
		Collections.shuffle(list);
		Collections.sort(list);
		int idx = Collections.binarySearch(list, 7);
		if (idx >= 0)
			System.out.println((idx+1) + "번 째 위치에 있습니다.");
		else {
			System.out.println("7은 리스트에 없습니다.");
		}
		
	}
	
//	public static <T extends Comparable<T>>int binarySearch2(List<T> list, T key) {
	public static <T> int binarySearch2(List<? extends Comparable<T>> list, T key) {
		int left = 0;
		int right = list.size() -1;
		
		// left가 right 이하인 동안 다음을 반복
		
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
		
		return left*(-1); // 이 값의 절대값이 key가 와야될 위치.
	
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
