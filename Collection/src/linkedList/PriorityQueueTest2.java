package linkedList;
import java.util.*;

public class PriorityQueueTest2 {

	public static void main(String[] args) {
//		test1();
		test2();
	}
	
	private static void test2() {
		/*
		  �켱���� ť�� �� ���Ҹ� �����ϴ� ����� 2������ �ִ�.
		  1. �׿����� Ŭ���� Comparable �������̽��� �����ϴ� ��
		  2. �켱���� ť���� �� ���Ҹ� ���ϴ� ����� ���� �˷��ִ� ��
		    => Comparator �������̽��� �����ϴ� ���̴�.
		   �����, ���Ұ� Comparable �������̽��� ������ ��ü�̰�
		   		�켱���� ť���� ���Ҹ� ���ϴ� ����� ���� �˷��ָ�
		   		����ü � ������ �����϶�� �ǰ�?
		 */
//		Queue<MyTask> q = new PriorityQueue<>();
		MyTaskComparator comp = new MyTaskComparator();
//		Queue<MyTask> q = new PriorityQueue<>(comp);
//		Queue<MyTask> q = new PriorityQueue<>(new Comparator<MyTask>() {
//
//			@Override
//			public int compare(MyTask o1, MyTask o2) {
//				// TODO Auto-generated method stub
//				return o2.priority - o1.priority;
//			}
//			
//		});
		
		// �ڹٿ��� ���ٶ�? 
		// �����ϳ��� �߻� �޼ҵ常�� ���� �������̽��� ����ü
		
		Queue<MyTask> q = new PriorityQueue<>(
				(o1, o2) -> o2.priority - o1.priority
				/*{return o2.priority - o1.priority;}*/
				);
		
		q.add(new MyTask(5, "�۾�1"));
		q.add(new MyTask(1, "�۾�2"));
		q.add(new MyTask(7, "�۾�3"));
		q.add(new MyTask(8, "�۾�4"));
		q.add(new MyTask(4, "�۾�5"));
		
		while(q.size() > 0) {
			MyTask task = q.poll();
			System.out.print(task);
		}
	}
	
	private static void test1() {
		Queue<Integer> q = new PriorityQueue<>();
		
		Random random = new Random();
		
		
		// �������� 1~100������ 10���� ������ ����.
		for (int i = 0; i < 10; i++) {
			int val = random.nextInt(100)+1;
			q.offer(val);
		}
		// ť ���� ������ ����غ���
		System.out.println(q);
		
		// ť�� ���Ҹ� �ϳ��� ������� ������
		while(q.size() > 0) {
			System.out.print(q.poll() + " ");
		}
		
		
	}
	
}

class MyTask implements Comparable<MyTask> {
	int priority;
	String desc;
	
	public MyTask(int priority, String desc) {
		this.priority = priority;
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "[priority:" + priority + ",desc:" + desc+"]\n";
	}
	@Override
	public int compareTo(MyTask o) {
		// ���� ũ�� ���, ������ 0, ���� ������ ������ ��ȯ�ϸ� �ȴ�.
		return this.priority - o.priority;
	}
	
}

class MyTaskComparator implements Comparator<MyTask> {

	@Override
	public int compare(MyTask o1, MyTask o2) {
		// o1�� ũ�� ���, ������ 0, o2�� ũ�� ������ ��ȯ
		// return o1.desc.compareTo(o2.desc); 
		// <= desc�������� �����ϰ� �ʹٸ�
		return (-1) * (o1.priority - o2.priority);
	}
	
}


