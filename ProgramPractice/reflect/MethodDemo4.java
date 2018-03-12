/**
 * @author LZD		2018/03/12
 */
/*
 * ͨ�������˽ⷺ�͵ı��ʣ�
 * ����ֻ�ڱ���ʱ����Ч��������ֽ����ļ�֮����Ч��������ȥ���ͻ���
 * ����Ĳ�����Class�Ĳ�����Method�Ĳ�����Field�Ĳ��������ƹ����룬������ʱ��ִ�е�
 */
package reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class MethodDemo4 {

	public static void main(String[] args) {
		ArrayList list1 = new ArrayList();
		ArrayList<String> list2 = new ArrayList<>();
		
		list2.add("hello");
//		list2.add(10);     // �������Ͳ�ƥ��
		
		Class c1 = list1.getClass();
		Class c2 = list2.getClass();
		
		System.out.println(c1 == c2);
		/*
		 * ��ӡ���Ϊtrue����������ֻ���ڱ���ʱ����Ч�ģ��ڱ�������ȥ���ͻ���
		 * Java�м��Ϸ����Ƿ�ֹ��������ģ�ֻ���ڱ���ʱ����Ч���ƹ��������Ч��
		 * ��֤(�����ʹ��)��ͨ�������ķ������������ƹ�����
		 */
		try {
			Method m = c2.getMethod("add", Object.class);
			m.invoke(list2, 10);     // �ƹ��������������ƹ��˷���
			System.out.println(list2.size());   // �����2
			System.out.println(list2);    // �����[hello, 10]
			/*
			 * �����������������ת������
			 * hello
			 * java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
			 * 	at reflect.MethodDemo4.main(MethodDemo4.java:36)
			 */
//			for (String string : list2) {
//				System.out.println(string);
//			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
