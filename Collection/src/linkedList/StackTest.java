package linkedList;

import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class StackTest {

	public static void main(String[] args) {
		
//		test1();
//		test2();
		checkExpression();
	}
	private static void checkExpression() {
		System.out.println("������ �Է��ϼ���");
		Scanner input = new Scanner(System.in);
		String exp = input.nextLine();
		
//		Stack
		Stack<String> stack = new Stack<>();
		
		StringTokenizer st = new StringTokenizer(exp);
		
		while(st.hasMoreTokens()) {
			
//			System.out.println(st.nextToken());
			String nextVal = st.nextToken();
			
			 /*( �̸� stack�� push
			  )�̸� stack����
			  stack�� empty���� Ȯ��, empty�� �ƴϸ� pop
			  empty �̸� �߸��� ���ΰ���...
			  �߸��� ������ ����ϰ� .. return;
			 */			
			if (nextVal.equals("(")) {
				stack.push(nextVal);
			} else if (nextVal.equals(")")) {
				if(stack.empty()) {
					System.out.println("�߸��� ���Դϴ�.");
					return;
				}
				stack.pop();
				
			}
		}		
		
		if (stack.empty()) {
			System.out.println("��ȿ�� ���Դϴ�.");
		} else {
			System.out.println("�߸��� ���Դϴ�.");
		}
				
	}
	
	private static void test2() {
		
		String str = "APPLE, GRAPE, BANANA, MELON, STRAWBERRY";
		StringTokenizer st = new StringTokenizer(str, ", ");
		while(st.hasMoreTokens()) {
			System.out.println("["+st.nextToken()+"]");
		}
	}
	
	private static void test1() {
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i<10; i++) {
			// auto boxing
			// stack.push(Character c)); // char�� Wrapper class
			// stack.push(char c);
			stack.push((char)('A'+i));
		}
		System.out.println(stack);
		// ������ ����� ���� ������
		System.out.println("������ ����� ���� : " + stack.peek());
		System.out.println("������ ����� ���� : " + stack.peek());
		
		System.out.println("������ ����� ���� : " + stack.peek());
		while(stack.size() > 0) {
			Character nextVal =  stack.pop();
//			System.out.println(nextVal);
			
			
			
			if(nextVal == '(') {
				stack.push(nextVal);
			} else if(nextVal == ')') {
				
			}
			
		}
		// stack�� empty�� ��ȿ�� ������ ���
		// �׷��� ������ �߸��� ������ ���
//		Iterator<Character> 
		System.out.println(stack);
		
	}
	
	
}
