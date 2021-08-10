package Object;

class Car {
	private String modelName;
	private int modelYear;
	private String color;
	private int maxSpeed;
	
	Car(String modelName, int modelYear, String color, int maxSpeed) {
		this.modelName = modelName;
		this.modelYear = modelYear;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
	
	Car() {
		this("�ƹݶ�", 2016, "���", 200);
	}
	
	public String getModel() {
		return this.modelYear + "��� " + this.modelName + " " + this.color;
	}
}

public class prog2 {
	public static void main(String[] args) {
		Car car01 = new Car();
		Car car02 = new Car();
		System.out.println(car01.equals(car02));
		
		car01 = car02;			// �� ���� ������ ���� �ּҸ� ����Ŵ.
		System.out.println(car01.equals(car02));
	}
}
