
public class Cyphers {
	public static void main(String[] args) {
		
		Louis ls = new Louis();
		ls.run();
		
	}
}

abstract class Person {

	abstract void leftClick();
	abstract void rightClick();
	abstract void pushE();
	abstract void pushF();
	abstract void pushSpace();
}

class Louis extends Person {
	
	public Louis() {}
	
	public void run() {
		
		leftClick();
		rightClick();
		pushE();
		pushF();
		pushSpace();
		
		
	}
	
	

	@Override
	void leftClick() {
		// TODO Auto-generated method stub
		System.out.println("������");
	}

	@Override
	void rightClick() {
		// TODO Auto-generated method stub
		System.out.println("���帮����");

	}

	@Override
	void pushE() {
		// TODO Auto-generated method stub
		System.out.println("��������");

	}

	@Override
	void pushF() {
		// TODO Auto-generated method stub
		System.out.println("������ ��ġ");

	}

	@Override
	void pushSpace() {
		// TODO Auto-generated method stub
		System.out.println("���� �����̵�");

	}
	
}