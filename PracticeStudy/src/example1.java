class Parent{
    int age=45;
    String name="Parent";
    public Parent(){
        System.out.println("Parent Default Constructor");
    }
    public Parent(int _age,String _name){
        age=_age;
        name=_name;
        System.out.println("Parent Constructor");
    }
    public void showInfo(){
        System.out.println("Name:"+name+", age:"+age);
    }
}
 
class Child extends Parent{
    public Child(int _age, String _name){
        System.out.println("Child Constructor");
    }
}
public class example1 {
 
    public static void main(String[] args){
        Child a=new Child(25,"REAKWON");
        a.showInfo();
    }
}
