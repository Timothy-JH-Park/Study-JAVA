package Object2;

public class wrapper3 {

    public static void main(String[] args) {

        Integer num1 = new Integer(10);

        Integer num2 = new Integer(20);

        Integer num3 = new Integer(10);

 

        System.out.println(num1 < num2);       // true

       System.out.println(num1 == num3);      // false

       System.out.println(num1.equals(num3)); // true

    }

}
