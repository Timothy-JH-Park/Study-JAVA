
public class breakExample {
	
	public static void main(String[] args) {
	Otter: for (char upper = 'A'; upper <= 'Z'; upper++) {   // Otter��� �� ����
	  for (char lower = 'a'; lower <= 'z'; lower++) {
	    System.out.println(upper + "-" + lower);
	    
	    if (lower == 'g') {
	        break Otter;    // break Otter;�� ����� �ٱ��� �ݺ������� ����
	    }
	  }
	}
	System.out.println("���α׷� ���� ����");
	}
}