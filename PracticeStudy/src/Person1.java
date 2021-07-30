package lambda;

interface Say{
	Person1 rin = new Person1();
	rin.hi(new Say() {
	    public int someting(int a, int b) {
		System.out.println("My Name is Coding-Factory");
		System.out.println("Nice to meet you");
		System.out.println("parameter number is "+a+","+b);
		return 7;
	    }
	});
}
class Person1{
    public void hi(Say line) {
	int number = line.someting(3,4);
	System.out.println("Number is "+number);
    }
}

