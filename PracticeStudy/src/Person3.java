package lambda;

@FunctionalInterface
interface Say{
	Person2 rin = new Person2();
    rin.hi((a,b) ->{
    	System.out.println("This is Coding-Factory!");
    	System.out.println("Tank you Lamda");
    	System.out.println("parameter number is "+a+","+b);
        return 0;
    });
}
public class Person3{
    public static void hi (String[] args)
    {
	int number = args.length;
	System.out.println("Number is "+number);
    }
    
    
}
