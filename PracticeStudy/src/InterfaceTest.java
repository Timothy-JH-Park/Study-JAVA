
interface catWorld{
    public void call();
}
 
 
public class InterfaceTest implements catWorld{
    
    public void call() { //�������̵�
        System.out.println("�߿˾߿�!");
    }
    
    public static void main(String[] args) {
        InterfaceTest it = new InterfaceTest();
        
        it.call();
    }
 
}