package MainExercise;

public class conditional {

	public static void main(String[] args) {
		
		String a = "Man";
		int b = 3;
		
		// �ڹٴ� String�� ���� �� equal()�� �̿��մϴ�.
		// �� ������ String�� ��Ÿ �ڷ����� �ٸ� ���ڿ� �ڷ����̱� ����
		if(a.equals("Man"))
		{
			System.out.println("�����Դϴ�");
		}
		else
		{
			System.out.println("���ڰ� �ƴմϴ�");
		}
		if(b == 3)
		{
			System.out.println("b�� 3�Դϴ�");
		}
		else
		{
			System.out.println("3�� �ƴմϴ�");
		}
		
		if(a.equalsIgnoreCase("man") && b == 0)
		{
			System.out.println("���Դϴ�");
		}
		else
		{
			System.out.println("�����Դϴ�");
		}
		
	}
}
