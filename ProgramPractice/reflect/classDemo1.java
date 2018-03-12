/**
 * @author LZD		2018/03/11
 */
/*
 * ��������Զ���һ����Ҳ��һ����������java.lang.Class��Ķ���
 * ���Ļ�ȡ����������
 */
package reflect;

public class classDemo1 {

	public static void main(String[] args) {
		// foo1��Foo���ʵ������
		Foo foo1 = new Foo();  // ��ʾ������new��������
		
		// Foo�����Ҳ��һ��ʵ��������Class���ʵ������
		// �κ�һ���඼��Class��ʵ���������ʵ�����������ֱ�﷽ʽ
		
		// ��һ�֣�ʵ�����ڸ������� ---> ÿһ���඼��һ�������ľ�̬��Աclass
		Class c1 = Foo.class;
		
		//�ڶ��֣�ʹ���Ѵ�����ʵ�����󣬲���������getClass����
		Class c2 = foo1.getClass();
		
		/*
		 * ������c1, c2��ʾ��Foo���������(ClassType)
		 * ���ǽ�����������Զ�����Ҳ�Ƕ�����Class��Ķ���
		 * Class��Ķ������ǳ�Ϊ�����������
		 * e.g.
		 * 	Foo��Ķ���foo1��
		 * 	Foo��������ͣ�c1, c2
		 */
		
		// ������ c1 or c2 ��������Foo�������ͣ���������ȵ�
		System.out.println(c1 == c2);
		
		// �����ֱ�﷽ʽ��
		Class c3 = null;
		try {
			c3 = Class.forName("reflect.Foo");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(c2 == c3);
		
		// ������ȫ����ͨ����������ʹ�������Ķ���ʵ�� ---> ͨ��c1 or c2 or c3����Foo���ʵ��
		try {
			// �ܹ�ͨ�������ʹ�������ʵ����ǰ���ǣ��������޲ι���
			Foo foo = (Foo) c1.newInstance();
			foo.print();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

class Foo{
	
	void print() {
		System.out.println("foo!");
	}
}