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
			list.add(new Student2("�̸�"+i, random.nextInt(100)+1));
		}
		System.out.println(list);
		sort(list);
//		Collections.sort(list);
		System.out.println("���� ��...");
		System.out.println(list);
		
	}
	
	private static <T extends Comparable<T>> void sort (List<T> list) {
		/*
		 * selection sort
		 */
		/*
		 * list�� 0������ ������ �ε����� ���ұ��� ������ �ݺ�
		 * 		���� �ε����� i�� ����.
		 * 		min = i;
		 * 
		 * 		list�� ��+1�� �ε������� ������ �ε����� ���ұ��� ������ �ݺ�
		 * 			��ø �ݺ����� ���� �ε����� j�� ����.
		 * 			if (min �ε����� ���Ұ����� j�ε����� ���Ұ��� ������)
		 * 				min = j;
		 * 
		 * 		i��° �ε����� min ��° �ε����� ���� swap
		 * 
		 */
		for (int i = 0; i < list.size(); i++) {
			int min = i;
			for (int j = i+1; j < list.size(); j++) {
				if(list.get(min).compareTo(list.get(j)) > 0) {
					min = j;
				}
			}
			// min ������ ����Ű�� ��ġ�� ���Ұ� ���� ���� �����ִ� �� �߿����� ���� ����.
			// �� ���� i ��ġ�� �;��Ѵ�.
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
