/**
 * @author LZD		2018/03/11
 */
/*
 * ������ʹ��֮ --- ��ȡ�κ�һ�����ȫ����Ϣ
 * ����һ�������࣬����printClassMessage�����Ϳ��Ի�ô�������������Ϣ
 */
package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassUtil {

	/**
	 * ��ӡ��ĳ�Ա��������Ϣ
	 * @param obj
	 */
	public static void printClassMethodMessage(Object obj) {
		
		// Ҫ��ȡ�����Ϣ������Ҫ��ȡ���������()
		Class c = obj.getClass();    // ���ݵ����ĸ�����Ķ���c �����ĸ����������
		
		// ��ȡ�������
		System.out.println("�������������ǣ�" + c.getName());
		
		/*
		 * ��ȡ��ķ���
		 * Method�࣬�Ƿ�������
		 * һ����Ա��������һ��Method����
		 * Method���з�װ�˶������Ա�����Ĳ���
		 * getMethods()��õķ����ǣ�����public���εķ����������Ӹ���̳ж�����
		 * getDeclaredMethods()��õķ����ǣ����и����Լ������ķ���������������ģ��޹ط���Ȩ��
		 */
		Method[] ms = c.getMethods();
		Method[] ms2 = c.getDeclaredMethods();
		
		// ��ȡ��Щ��������Ϣ(����ֵ���������Ͳ����б�)
		for(int i = 0;i < ms.length;i++) {
			/*
			 * ��ȡ�����ķ���ֵ
			 * 1.��ȡ�����ķ���ֵ������
			 * 2.��ȡ�����ķ���ֵ���͵�����
			 */
			Class returnType = ms[i].getReturnType();
			System.out.print(returnType.getName() + " ");
			
			// �õ�����������
			System.out.print(ms[i].getName() + "(");
			
			// ��ȡ�������� ---> �õ����ǲ����б�����͵�������
			Class[] paramTypes = ms[i].getParameterTypes();
			for (Class class1 : paramTypes) {
				System.out.print(class1.getName() + ", ");
			}
			System.out.println(")");
		}
	}

	/**
	 * ��ȡ��Ա��������Ϣ
	 * @param obj
	 */
	public static void printClassFieldMessage(Object obj) {
		Class classs = obj.getClass();
		/*
		 * ��Ա����Ҳ�Ƕ���
		 * java.lang.reflect.Field
		 * Field���װ�˹��ڳ�Ա�����Ĳ���
		 * getFields()������ȡ�������е�public�ĳ�Ա��������Ϣ
		 * getDeclaredFields()������ȡ���Ǹ����Լ������ĳ�Ա��������Ϣ
		 */
		// Field[] fs = c.getFields();
		Field[] fs = classs.getDeclaredFields();
		for (Field field : fs) {
			// ȡ�ó�Ա�������͵������ʹӶ���ȡ��Ա��������������
			Class fieldType = field.getClass();
			String typeName = fieldType.getSimpleName();
			// ��ȡ��Ա����������
			String fieldName = field.getName();
			System.out.println(typeName + " " + fieldName);

		}
	}
	
	/**
	 * 
	 * @param obj
	 */
	public static void printConsMessage(Object obj) {
		Class c = obj.getClass();
		/*
		 * ���캯��Ҳ�Ƕ���
		 * java.lang.Constructor�з�װ�˹��캯������Ϣ
		 * getConstructors()������ȡ���е�public�Ĺ��췽��
		 * getDeclaredConstructors()������ȡ�����Լ������Ĺ��췽��
		 */
//		Constructor[] cs = c.getConstructors();
		Constructor[] cs = c.getDeclaredConstructors();
		for (Constructor constructor : cs) {
			// ��ȡ���췽��������
			System.out.print(constructor.getName() + "(");
			// ��ȡ���췽���Ĳ����б�
			Class[] paramTypes = constructor.getParameterTypes();
			for (Class class1 : paramTypes) {
				String paramName = class1.getSimpleName();
				System.out.print(paramName + ", ");
			}
			System.out.println(")");
		}
	}
	
	
	
	
}
