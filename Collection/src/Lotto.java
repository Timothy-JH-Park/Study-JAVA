package linkedList;

import java.util.*;
import java.util.stream.*;

public class Lotto {

	public static void main(String[] args) {
		Set<Integer> set = new TreeSet<>();
		
		//set 6���� ���Ұ� �� ������
		//1~45 ������ ������ ���� ������ add �ϸ� ��
		Random rand = new Random(System.currentTimeMillis());
		
		while(set.size() < 6) {
			int num = rand.nextInt(45)+1;
			set.add(num);
		}
		System.out.println(set);
		System.out.println("������ �� : " + set.size());
		
		//���Ұ� �� �� �ִ��� �� �� �ִ�
		//����� ������������ ���ĵ� ������...
		
	}
}
