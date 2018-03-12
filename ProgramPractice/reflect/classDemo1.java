/**
 * @author LZD		2018/03/11
 */
/*
 * 万事万物皆对象，一个类也是一个对象，它是java.lang.Class类的对象
 * 它的获取方法有三种
 */
package reflect;

public class classDemo1 {

	public static void main(String[] args) {
		// foo1是Foo类的实例对象
		Foo foo1 = new Foo();  // 表示方法：new创建对象
		
		// Foo这个类也是一个实例对象，是Class类的实例对象
		// 任何一个类都是Class的实例对象，这个实例对象有三种表达方式
		
		// 第一种：实际是在告诉我们 ---> 每一个类都有一个隐含的静态成员class
		Class c1 = Foo.class;
		
		//第二种：使用已创建的实例对象，并调用它的getClass方法
		Class c2 = foo1.getClass();
		
		/*
		 * 官网：c1, c2表示了Foo类的类类型(ClassType)
		 * 我们讲，万事万物皆对象，类也是对象，是Class类的对象
		 * Class类的对象，我们称为该类的类类型
		 * e.g.
		 * 	Foo类的对象：foo1；
		 * 	Foo类的类类型：c1, c2
		 */
		
		// 不管是 c1 or c2 都代表了Foo的类类型，所以是相等的
		System.out.println(c1 == c2);
		
		// 第三种表达方式：
		Class c3 = null;
		try {
			c3 = Class.forName("reflect.Foo");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(c2 == c3);
		
		// 我们完全可以通过类的类类型创建该类的对象实例 ---> 通过c1 or c2 or c3创建Foo类的实例
		try {
			// 能够通过类类型创建对象实例的前提是：该类有无参构造
			Foo foo = (Foo) c1.newInstance();
			foo.print();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

class Foo{
	
	void print() {
		System.out.println("foo!");
	}
}