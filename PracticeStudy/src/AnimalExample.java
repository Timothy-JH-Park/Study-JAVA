
public class AnimalExample {
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Dog dog = new Dog();
        Cat cat = new Cat();
         
        dog.sound();
        cat.sound();
         
        Animal animal = null;
         
        animal = new Dog(); //�ڵ� Ÿ�Ժ�ȯ
        animal.sound(); //Dog�� ������ Sound()�޼��� ����
         
        animal = new Cat(); //�ڵ� Ÿ�Ժ�ȯ
        animal.sound(); //Cat�� ������ Sound()�޼��� ����
         
         
        animalSound(new Dog()); //�ڵ� Ÿ�Ժ�ȯ (�Ű������� ����)
        animalSound(new Cat()); //�ڵ� Ÿ�Ժ�ȯ (�Ű������� ����)
    }
    //�ڵ� Ÿ�Ժ�ȯ : �߻�Ŭ���� Ÿ�� ������ �߻�Ŭ������ ��ӹ��� ��üŬ������ Ÿ������ �ڵ� Ÿ�Ժ�ȯ�� �ȴ�. 
    private static void animalSound(Animal animal) {
        animal.sound();
    }
}