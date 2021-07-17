
public class breakExample {
	
	public static void main(String[] args) {
	Otter: for (char upper = 'A'; upper <= 'Z'; upper++) {   // Otter라는 라벨 붙임
	  for (char lower = 'a'; lower <= 'z'; lower++) {
	    System.out.println(upper + "-" + lower);
	    
	    if (lower == 'g') {
	        break Otter;    // break Otter;을 사용해 바깥쪽 반복문까지 종료
	    }
	  }
	}
	System.out.println("프로그램 실행 종료");
	}
}