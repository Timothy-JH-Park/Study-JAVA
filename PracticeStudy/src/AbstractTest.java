
public class AbstractTest {
    public static void main(String[] args) {
        FirstCat fc = new FirstCat();
        SecondCat sc = new SecondCat();
        
        fc.call();
        sc.call();
    }
}//AbstractTest
 
abstract class Cat{ // �߻� �޼��带 �����ϹǷ� �߻�Ŭ������ ����
    abstract void call(); // �߻� �޼��� ����(����x)
    void call2(){
        System.out.println("�Ϲ� �޼���");
    }
}
 
//Cat �߻�Ŭ������ ����� Ŭ������
class FirstCat extends Cat{
    void call(){ //�߻�޼���� ����Ŭ�������� �ݵ�� ������ �Ǿ�� ��
        System.out.println("ù��° �߿���");
    }
}
 
class SecondCat extends Cat{
    void call(){
        System.out.println("�ι�° �߿���");
    }
}

