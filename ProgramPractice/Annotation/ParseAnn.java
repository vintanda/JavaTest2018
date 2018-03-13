/**
 * @author LZD		2018/03/12
 */
/*
 * ע��Ľ�������ϸ�������е�ע��
 */
package Annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class ParseAnn {

	public static void main(String[] args) {
		// 1.ʹ���������������
		try {
			Class c = Class.forName("Annotation.Child");
			// 2.�ҵ��������ע�� isAnnotationPresent���ж��Ƿ�������ע��
			boolean isExist = c.isAnnotationPresent(Description.class);
			if(isExist) {
				// 3.���ڣ��õ�ע��ʵ��
				// ע�������ȡע��ʵ���Ǵ�����������л�ȡ
				Description d = (Description) c.getAnnotation(Description.class);
				System.out.println(d.value());
			}
			
			
			// ���������õ������ϵ�Descriptionע�������
			// 4.�ҵ������ϵ�ע��
			// ������з���
			Method[] ms = c.getMethods();
			// �������еķ�������ȡ��ע��
			for (Method method : ms) {
				boolean isMethodExist = method.isAnnotationPresent(Description.class);
				if(isMethodExist) {
					// ע�������ȡע��ʵ���Ǵӷ����л�ȡ
					Description d = (Description) method.getAnnotation(Description.class);
					System.out.println(d.value());
				}
			}
			
			// ��һ�ַ�����ȡ������ע��
			for (Method method : ms) {
				// ���Ȼ�ȡ���е�ע��ʵ������
				Annotation[] as = method.getAnnotations();
				// �������е�ע��ʵ������
				for (Annotation annotation : as) {
					// �����ǰע����Descriptionע���ʵ����Description�����ʵ��
					if(annotation instanceof Description) {
						Description d = (Description) annotation;
						System.out.println(d.value());
					}
				}
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
