package discuss;

public class Test01 {

int �������; // �� �������

void test() {

System.out.println("test() : ����� ������ ��.  ");

if(true)

return;

System.out.println("����� ������ �ȵȴ�. ");

}

int test2() {

return 0;

}



public static void main(String[] args) {

Test01 t = new Test01();

System.out.println(" void �Լ����� return; �̶� �Լ��� �����Ű�� �ǹ�."
		+ "�ƹ��͵� �������� ���� �� �Լ��� ��ħ. ");

t.test();

int tmp = t.test2();

System.out.println(" return �̶� � ���̳� ��ü�� �ǵ����ش� ��� �ǹ� . tmp : "+tmp);

}

}
