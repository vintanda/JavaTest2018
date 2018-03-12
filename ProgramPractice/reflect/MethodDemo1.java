/**
 * @author LZD		2018/03/12
 */
/*
 * �����ķ���
 * ʹ�÷����ķ�����÷�����method.invoke(���󣬲����б�);
 * ���裺
 * 	1.��ȡ�����Ϣ(�Ȼ�ȡ������)
 * 	2.��ȡ���������ƺͲ����б�������õķ���
 * 	3.ʹ��invoke�������з�������
 */
package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodDemo1 {

	public static void main(String[] args) {
		/*
		 *  Ҫ��ȡprint(int a, int b)����
		 *  1.Ҫ��ȡһ���������ǻ�ȡ�����Ϣ����ȡ�����Ϣ��Ҫ�Ȼ�ȡ���������
		 */
		A a = new A();
		Class c = a.getClass();
		/*
		 * 2.��ȡ���������ƺͲ����б�������õķ���
		 */
		try {
			// ��ȡ������
			// ���� Method m = c.getMethod("print", int.class, int.class);
			Method m1 = c.getMethod("print", new Class[] {int.class, int.class});
			
			// 3.ʹ��invoke�������з�������(����Ƿ����ķ������)
			// �� a.print(10, 20);��Ч������ͬ��
			// ���� m.invoke(a, new Object[]{10, 20});
			// ����û�з���ֵ�ͷ���null������з���ֵ�ͷ��ص�Object o��
			Object o1 = m1.invoke(a, 10,20);
			System.out.println("========================================");
			
			Method m2 = c.getMethod("print", String.class, String.class);
			Object o2 = m2.invoke(a, new Object[] {"hello", "WORLD"});
			System.out.println("========================================");
			
			// �޲εķ����ķ��������
//			Method m3 = c.getMethod("print", new Class[] {});
			Method m3 = c.getMethod("print");
//			Object o3 = m3.invoke(a, new Object[] {});
			Object o3 = m3.invoke(a);
			
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

// ��ϰʹ�õĶ������
class A {
	public void print() {
		System.out.println("methodReflect");
	}
	public void print(int a, int b) {
		System.out.println(a + b);
	}
	
	public void print(String a, String b) {
		System.out.print(a.toUpperCase());
		System.out.println(b.toLowerCase());
	}
}