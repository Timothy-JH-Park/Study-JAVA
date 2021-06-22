package linkedList;

import java.util.*;
import java.util.stream.*;

public class Lotto {

	public static void main(String[] args) {
		Set<Integer> set = new TreeSet<>();
		
		//set 6개의 원소가 들어갈 때까지
		//1~45 사이의 무작위 값을 생성해 add 하면 됨
		Random rand = new Random(System.currentTimeMillis());
		
		while(set.size() < 6) {
			int num = rand.nextInt(45)+1;
			set.add(num);
		}
		System.out.println(set);
		System.out.println("원소의 수 : " + set.size());
		
		//원소가 몇 개 있는지 알 수 있다
		//출력은 오름차순으로 정렬된 순서로...
		
	}
}
