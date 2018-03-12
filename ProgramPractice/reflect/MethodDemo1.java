/**
 * @author LZD		2018/03/12
 */
/*
 * 方法的反射
 * 使用方法的反射调用方法：method.invoke(对象，参数列表);
 * 步骤：
 * 	1.获取类的信息(先获取类类型)
 * 	2.获取方法的名称和参数列表决定调用的方法
 * 	3.使用invoke方法进行方法调用
 */
package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodDemo1 {

	public static void main(String[] args) {
		/*
		 *  要获取print(int a, int b)方法
		 *  1.要获取一个方法就是获取类的信息，获取类的信息就要先获取类的类类型
		 */
		A a = new A();
		Class c = a.getClass();
		/*
		 * 2.获取方法的名称和参数列表决定调用的方法
		 */
		try {
			// 获取方法类
			// 或者 Method m = c.getMethod("print", int.class, int.class);
			Method m1 = c.getMethod("print", new Class[] {int.class, int.class});
			
			// 3.使用invoke方法进行方法调用(这就是方法的反射操作)
			// 与 a.print(10, 20);的效果是相同的
			// 或者 m.invoke(a, new Object[]{10, 20});
			// 方法没有返回值就返回null，如果有返回值就返回到Object o中
			Object o1 = m1.invoke(a, 10,20);
			System.out.println("========================================");
			
			Method m2 = c.getMethod("print", String.class, String.class);
			Object o2 = m2.invoke(a, new Object[] {"hello", "WORLD"});
			System.out.println("========================================");
			
			// 无参的方法的反射操作：
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

// 练习使用的定义的类
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