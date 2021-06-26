package map;

import java.util.*;

public class MapTest4 {

	public static void main(String[] args) {
		test1();
	}
	
	private static void test1() {
//		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Student2> list = new ArrayList<>();
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
//			list.add(random.nextInt(100)+1);
			list.add(new Student2("이름"+i, random.nextInt(100)+1));
		}
		System.out.println(list);
		sort(list);
//		Collections.sort(list);
		System.out.println("정렬 후...");
		System.out.println(list);
		
	}
	
	private static <T extends Comparable<T>> void sort (List<T> list) {
		/*
		 * selection sort
		 */
		/*
		 * list의 0번부터 마지막 인덱스의 원소까지 다음을 반복
		 * 		현재 인덱스를 i라 하자.
		 * 		min = i;
		 * 
		 * 		list의 ㅑ+1번 인덱스부터 마지막 인덱스의 원소까지 다음을 반복
		 * 			중첩 반복문의 현재 인덱스를 j라 하자.
		 * 			if (min 인덱스의 원소값보다 j인덱스의 원소값이 작으면)
		 * 				min = j;
		 * 
		 * 		i번째 인덱스와 min 번째 인덱스의 값을 swap
		 * 
		 */
		for (int i = 0; i < list.size(); i++) {
			int min = i;
			for (int j = i+1; j < list.size(); j++) {
				if(list.get(min).compareTo(list.get(j)) > 0) {
					min = j;
				}
			}
			// min 변수가 가리키는 위치의 원소가 지금 현재 남아있는 것 중에서는 제일 작음.
			// 이 놈이 i 위치에 와야한다.
//			swap(list.get(min), list.get(i));
			swap(list, min, i);
			
			
		}
		
	}
//	private void swap(Student s1, Student s2)
	private static <T extends Comparable<T>> void swap(List<T> list, int i, int j)
	{
		T tmp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, tmp);
	}
	
}

class Student2 implements Comparable<Student2>{
	private String name;
	private int grade;
	
	
	@Override
	public String toString() {
		return "[name :" + name + ", grade:" + grade + "]\n";
	}
	public Student2(String name, int grade) {
		super();
		this.name = name;
		this.grade = grade;
	}
	
	@Override
	
	public int compareTo(Student2 o) {
		return this.grade - o.grade;
	}
}
