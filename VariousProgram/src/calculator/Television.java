package remote;

public class Television implements RemoteControl {

	boolean onOff = false;
	
	public void turnOn() {
		onOff = true;
		System.out.println("����");
	}
	
	public void turnOff() {
		onOff = false;
		System.out.println("����");
	}
	
}
