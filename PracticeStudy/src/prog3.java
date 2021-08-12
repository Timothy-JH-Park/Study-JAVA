package Object2;
import java.util.*;

class Car implements Cloneable {
	private String modelName;
	private ArrayList<String> owners = new ArrayList<String>();

	public String getModelName() { return this.modelName; }
	public void setModelName(String modelName) { this.modelName = modelName; }

	public ArrayList getOwners() { return this.owners; }
	public void setOwners(String ownerName) { this.owners.add(ownerName); }
	
	public Object clone() {
		try {
			Car clonedCar = (Car)super.clone();
			// clonedCar.owners = (ArrayList)owners.clone();
			return clonedCar;
		} catch (CloneNotSupportedException ex) {
			ex.printStackTrace();
			return null;
		}
	}
}

public class prog3 {
	public static void main(String[] args) {
		Car car01 = new Car();

		car01.setModelName("¾Æ¹Ý¶¼");
		car01.setOwners("È«±æµ¿");
		System.out.println("Car01 : " + car01.getModelName() + ", " + car01.getOwners() + "\n");
		
		Car car02 = (Car)car01.clone();
		car02.setOwners("ÀÌ¼ø½Å");
		System.out.println("Car01 : " + car01.getModelName() + ", " + car01.getOwners());
		System.out.println("Car02 : " + car02.getModelName() + ", " + car02.getOwners());
	}
}
