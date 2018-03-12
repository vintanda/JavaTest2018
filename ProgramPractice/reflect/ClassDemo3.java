/**
 * @author LZD		2018/03/11
 */
/*
 * 方法的使用之 --- 获取任何一个类的全部信息
 * 这是一个测试类，
 * 调用工具类ClassUtil中的printClassMessage方法获得传入的类的所有方法信息
 * 调用工具类ClassUtil中的printClassMethodMessage方法获得传入的类的所有变量信息
 * 调用工具类ClassUtil中的printConsMessage方法获得传入的类的所有构造方法信息
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
