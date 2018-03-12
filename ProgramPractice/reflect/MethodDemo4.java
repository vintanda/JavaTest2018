/**
 * @author LZD		2018/03/12
 */
/*
 * 通过反射了解泛型的本质：
 * 泛型只在编译时期有效，编译成字节码文件之后无效，泛型是去泛型化的
 * 反射的操作、Class的操作、Method的操作、Field的操作都是绕过编译，在运行时候执行的
 */
package reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class MethodDemo4 {

	public static void main(String[] args) {
		ArrayList list1 = new ArrayList();
		ArrayList<String> list2 = new ArrayList<>();
		
		list2.add("hello");
//		list2.add(10);     // 报错，类型不匹配
		
		Class c1 = list1.getClass();
		Class c2 = list2.getClass();
		
		System.out.println(c1 == c2);
		/*
		 * 打印结果为true，表名泛型只是在编译时期有效的，在编译后就是去泛型化的
		 * Java中集合泛型是防止错误输入的，只是在编译时期有效，绕过编译就无效了
		 * 验证(反射的使用)：通过方法的反射来操作，绕过编译
		 */
		try {
			Method m = c2.getMethod("add", Object.class);
			m.invoke(list2, 10);     // 绕过编译器操作就绕过了泛型
			System.out.println(list2.size());   // 输出：2
			System.out.println(list2);    // 输出：[hello, 10]
			/*
			 * 输出：报错，出现类型转换错误
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
