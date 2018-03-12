/**
 * @author LZD		2018/03/11
 */
/*
 * 获取方法信息之 --- 获取方法名的多种方式
 */
package reflect;

public class ClassDemo2 {

	public static void main(String[] args) {
		Class c1 = int.class;       // int基本类型的类类型
		Class c2 = Integer.class;   // Integer包装类的类类型
		Class c3 = double.class;
		Class c4 = Double.class;
		Class c5 = String.class;
		Class c6 = void.class;
		
		// getName 基本类型打印的名称是基本类型的类型名
		// getName 获取类的全称
		// getSimpleName 只获得类的名称不打印包名(对基本类型来说两种无差别)
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
