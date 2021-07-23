package discuss;

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
 
class Child2 extends Parent{
    public Child2(){}
    public Child2(int _age, String _name){
        super(_age,_name);
        System.out.println("Child Constructor");
    }
    @Override
    public void showInfo(){
        System.out.println("Child showInfo");
        super.showInfo();
    }
}
public class exampleSolution2 {
 
    public static void main(String[] args){
        Child2 a=new Child2(25,"REAKWON");
        a.showInfo();
    }
}
