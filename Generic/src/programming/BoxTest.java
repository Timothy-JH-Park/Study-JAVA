package programming;

public class BoxTest {

	public static void main(String[] args) {
		Box box = new Box();
		box.setValue("ȫ�浿");
		String v = box.getValue();
		System.out.println(v);
				
		BoxInteger box2 = new BoxInteger();
		box.setValue(100);
		
		
	}
}
