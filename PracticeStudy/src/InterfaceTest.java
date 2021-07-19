
interface catWorld{
    public void call();
}
 
 
public class InterfaceTest implements catWorld{
    
    public void call() { //坷滚扼捞靛
        System.out.println("具克具克!");
    }
    
    public static void main(String[] args) {
        InterfaceTest it = new InterfaceTest();
        
        it.call();
    }
 
}