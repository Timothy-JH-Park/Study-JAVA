package test;

public class Test2 {

	public static void main(String[] args) {
		String id = "jhpark";
		String pw = "1234";
		
		try {
			login(id, pw);
			System.out.println("ȯ���մϴ�");
		} catch(Exception e) {
			//�α��� ���� ó�� ���� ����
			System.out.println("���̵� �Ǵ� ��ȣ�� �߸��Ǿ����ϴ�");
		}
		
		
	}
	
	private static void login(String id, String pw) 
								throws Exception{
		
//		try {
//			checkDB(id, pw);
//		} catch(Exception e) {
//			//���� ó��..
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
			//login ����
			System.out.println("�α��� ����");
		}
	}
	
	
}
