/**
 * @author LZD		2018/03/11
 */
/*
 * ��ȡ������Ϣ֮ --- ��ȡ�������Ķ��ַ�ʽ
 */
package reflect;

public class ClassDemo2 {

	public static void main(String[] args) {
		Class c1 = int.class;       // int�������͵�������
		Class c2 = Integer.class;   // Integer��װ���������
		Class c3 = double.class;
		Class c4 = Double.class;
		Class c5 = String.class;
		Class c6 = void.class;
		
		// getName �������ʹ�ӡ�������ǻ������͵�������
		// getName ��ȡ���ȫ��
		// getSimpleName ֻ���������Ʋ���ӡ����(�Ի���������˵�����޲��)
		System.out.println("c1Name:" + c1.getName());
		System.out.println("c1SimpleName:" + c1.getSimpleName());
		System.out.println("c2Name:" + c2.getName());
		System.out.println("c2SimpleName:" + c2.getSimpleName());
		System.out.println("c3Name:" + c3.getName());
		System.out.println("c4Name:" + c4.getName());
		System.out.println("c5Name:" + c5.getName());
		System.out.println("c6Name:" + c6.getName());
	}
}
