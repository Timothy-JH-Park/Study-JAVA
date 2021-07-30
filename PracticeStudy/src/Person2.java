package lambda;

@FunctionalInterface
interface Say2{
	Person2 rin = new Person2();
    rin.hi((a,b) ->{
    	System.out.println("This is Coding-Factory!");
    	System.out.println("Tank you Lamda");
    	System.out.println("parameter number is "+a+","+b);
        return 0;
    });
}
class Person2{
    public void hi(Say line) {
	int number = line.someting(3,4);
	System.out.println("Number is "+number);
    }
    
    
}
