/**
 * @author LZD		2018/03/12
 */
/*
 * 注解的解析，详细见代码中的注释
 */
package Annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class ParseAnn {

	public static void main(String[] args) {
		// 1.使用类加载器加载类
		try {
			Class c = Class.forName("Annotation.Child");
			// 2.找到类上面的注解 isAnnotationPresent是判断是否存在这个注解
			boolean isExist = c.isAnnotationPresent(Description.class);
			if(isExist) {
				// 3.存在，拿到注解实例
				// 注意这里获取注解实例是从类的类类型中获取
				Description d = (Description) c.getAnnotation(Description.class);
				System.out.println(d.value());
			}
			
			
			// 上面代码就拿到了类上的Description注解的名称
			// 4.找到方法上的注解
			// 获得所有方法
			Method[] ms = c.getMethods();
			// 遍历所有的方法并获取其注解
			for (Method method : ms) {
				boolean isMethodExist = method.isAnnotationPresent(Description.class);
				if(isMethodExist) {
					// 注意这里获取注解实例是从方法中获取
					Description d = (Description) method.getAnnotation(Description.class);
					System.out.println(d.value());
				}
			}
			
			// 另一种方法获取方法的注解
			for (Method method : ms) {
				// 首先获取所有的注解实例对象
				Annotation[] as = method.getAnnotations();
				// 遍历所有的注解实例对象
				for (Annotation annotation : as) {
					// 如果当前注解是Description注解的实例或Description子类的实例
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
