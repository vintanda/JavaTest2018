/**
 * @author LZD		2018/03/11
 */
/*
 * 方法的使用之 --- 获取任何一个类的全部信息
 * 这是一个工具类，调用printClassMessage方法就可以获得传入的类的所有信息
 */
package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassUtil {

	/**
	 * 打印类的成员函数的信息
	 * @param obj
	 */
	public static void printClassMethodMessage(Object obj) {
		
		// 要获取类的信息，首先要获取类的类类型()
		Class c = obj.getClass();    // 传递的是哪个子类的对象，c 就是哪个类的类类型
		
		// 获取类的名称
		System.out.println("传入的类的名称是：" + c.getName());
		
		/*
		 * 获取类的方法
		 * Method类，是方法对象
		 * 一个成员方法就是一个Method对象
		 * Method类中封装了对这个成员方法的操作
		 * getMethods()获得的方法是：所有public修饰的方法，包括从父类继承而来的
		 * getDeclaredMethods()获得的方法是：所有该类自己声明的方法，不包括父类的，无关访问权限
		 */
		Method[] ms = c.getMethods();
		Method[] ms2 = c.getDeclaredMethods();
		
		// 获取这些方法的信息(返回值、方法名和参数列表)
		for(int i = 0;i < ms.length;i++) {
			/*
			 * 获取方法的返回值
			 * 1.获取方法的返回值类类型
			 * 2.获取方法的返回值类型的名称
			 */
			Class returnType = ms[i].getReturnType();
			System.out.print(returnType.getName() + " ");
			
			// 得到方法的名称
			System.out.print(ms[i].getName() + "(");
			
			// 获取参数类型 ---> 得到的是参数列表的类型的类类型
			Class[] paramTypes = ms[i].getParameterTypes();
			for (Class class1 : paramTypes) {
				System.out.print(class1.getName() + ", ");
			}
			System.out.println(")");
		}
	}

	/**
	 * 获取成员变量的信息
	 * @param obj
	 */
	public static void printClassFieldMessage(Object obj) {
		Class classs = obj.getClass();
		/*
		 * 成员变量也是对象
		 * java.lang.reflect.Field
		 * Field类封装了关于成员变量的操作
		 * getFields()方法获取的是所有的public的成员变量的信息
		 * getDeclaredFields()方法获取的是该类自己声明的成员变量的信息
		 */
		// Field[] fs = c.getFields();
		Field[] fs = classs.getDeclaredFields();
		for (Field field : fs) {
			// 取得成员变量类型的类类型从而获取成员变量的类型名称
			Class fieldType = field.getClass();
			String typeName = fieldType.getSimpleName();
			// 获取成员变量的名称
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
		 * 构造函数也是对象，
		 * java.lang.Constructor中封装了构造函数的信息
		 * getConstructors()方法获取所有的public的构造方法
		 * getDeclaredConstructors()方法获取所有自己声明的构造方法
		 */
//		Constructor[] cs = c.getConstructors();
		Constructor[] cs = c.getDeclaredConstructors();
		for (Constructor constructor : cs) {
			// 获取构造方法的名字
			System.out.print(constructor.getName() + "(");
			// 获取构造方法的参数列表
			Class[] paramTypes = constructor.getParameterTypes();
			for (Class class1 : paramTypes) {
				String paramName = class1.getSimpleName();
				System.out.print(paramName + ", ");
			}
			System.out.println(")");
		}
	}
	
	
	
	
}
