package test;

public class Test2 {

	public static void main(String[] args) {
		String id = "jhpark";
		String pw = "1234";
		
		try {
			login(id, pw);
			System.out.println("환영합니다");
		} catch(Exception e) {
			//로그인 에로 처리 로직 실행
			System.out.println("아이디 또는 암호가 잘못되었습니다");
		}
		
		
	}
	
	private static void login(String id, String pw) 
								throws Exception{
		
//		try {
//			checkDB(id, pw);
//		} catch(Exception e) {
//			//오류 처리..
//			System.out.println(e.getMessage());
//		}
	
		checkDB(id, pw);
		
	}
	private static void checkDB(String id, String pw) 
								throws Exception {
		
		if(id.equals("jhpark") == false) {
			//id error
			throw new Exception("ID Error");
		} else if (pw.equals("1234") == false) {
			//pw error
			throw new Exception("Password Error");
			
		} else {
			//login 성공
			System.out.println("로그인 성공");
		}
	}
	
	
}
