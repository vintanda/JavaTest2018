/**
 * @author LZD		2018/03/11
 */
/*
 * ������ʹ��֮ --- ��ȡ�κ�һ�����ȫ����Ϣ
 * ����һ�������࣬
 * ���ù�����ClassUtil�е�printClassMessage������ô����������з�����Ϣ
 * ���ù�����ClassUtil�е�printClassMethodMessage������ô����������б�����Ϣ
 * ���ù�����ClassUtil�е�printConsMessage������ô����������й��췽����Ϣ
 */
package reflect;

public class ClassDemo3 {

	public static void main(String[] args) {
		String str = "hello";
		ClassUtil.printClassMethodMessage(str);
		System.out.println("====================================");
		ClassUtil.printClassMethodMessage(new Integer(1));
		System.out.println("====================================");
		ClassUtil.printConsMessage(new Double(2.0));
		System.out.println("====================================");
		ClassUtil.printConsMessage(str);
	}
}
