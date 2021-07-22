
public class AnimalExample2 {
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Dog dog = new Dog();
        Cat2 cat = new Cat2();
         
        dog.sound();
        cat.sound();
         
        Animal animal = null;
         
        animal = new Dog(); //�ڵ� Ÿ�Ժ�ȯ
        animal.sound(); //Dog�� ������ Sound()�޼��� ����
         
        animal = new Cat2(); //�ڵ� Ÿ�Ժ�ȯ
        animal.sound(); //Cat�� ������ Sound()�޼��� ����
         
         
        animalSound(new Dog()); //�ڵ� Ÿ�Ժ�ȯ (�Ű������� ����)
        animalSound(new Cat2()); //�ڵ� Ÿ�Ժ�ȯ (�Ű������� ����)
    }
    //�ڵ� Ÿ�Ժ�ȯ : �߻�Ŭ���� Ÿ�� ������ �߻�Ŭ������ ��ӹ��� ��üŬ������ Ÿ������ �ڵ� Ÿ�Ժ�ȯ�� �ȴ�. 
    private static void animalSound(Animal animal) {
        animal.sound();
    }
}