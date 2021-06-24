package linkedList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class Test {

	public static void main(String[] args) {
		
//		test();
//		test1();
		countDistictWord();
	}
		
	private static void countDistictWord() {
//		Set<String> set = new HashSet<>();
//		Map<String, Integer> map = new HashMap<>();
		Map<String, Integer> map = new TreeMap<>();
		
		File file = new File("C:/Users/pgh11/Desktop/새 폴더/Java.ver2/wordbook.txt");
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String s = null;
			while((s = br.readLine()) != null) {
				System.out.println("["+s.trim()+"]");
//				set.add(s);
				Integer n = map.get(s);
				if(n == null) {
					map.put(s, 1);
				
				} else {
					map.put(s, n+1);
				}
			}
			
			System.out.println(br.readLine());
		} catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
//		System.out.println("중복되지 않은 단어 수 : " + set.size());
		Set<String> set = map.keySet();
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			Integer value = map.get(key);
			System.out.println(key+":" + value + ", ");
			
		}
		
	}
	
	
	
	
	
	
	private static void test1() {
		// HashSet
		// 순서 없고, 중복 허용 안하는 집합 HashSet
//		Set<String> set = new LinkedHashSet<>();
		Set<String> set = new TreeSet<>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		});
		String[] strArr = {"단어", "중복", "구절", "중복"};
		for (String s : strArr) {
			if(set.add(s) == false) {
				System.out.println(s + "는 이미 존재하는 값..!");
			}
		}
		System.out.println(set);
		
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next() + " ");
		
		}
		System.out.println();
		iter = set.iterator();
		System.out.println(iter.next());
//		iter.next();
		System.out.println("끝..");
		
		
	}
	
	private static void test() {
		
//		List<Integer> list = new ArrayList<>();
		
		List<Integer> list = new LinkedList<>();
		
		IntStream.rangeClosed(1, 10000).forEach(i ->
		list.add(i));
		
		long startTime = System.currentTimeMillis();
		
		for (int i = 0; i < 100; i++) {
			list.add(100, (i+1)*1000);
		}
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("elapsed time : " + 
		(endTime-startTime));
		
		
	}
	private void test0() {
		List<String> list = new LinkedList<>();
		
		list.add("Apple");
		list.add("Grape");
		list.add("Butter");
		
		System.out.println(list);
		
		list.add(1, "Apple");
		System.out.println(list);
		
		list.set(2, "Grape");
		System.out.println(list);
		
		list.remove(3);
		System.out.println(list);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
		
		for (String s : list) {
			System.out.print(s + " ");
		}
		System.out.println();
		
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()) {
			iter.next();
		}
	}
	
			
}
