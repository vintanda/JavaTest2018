/**
 * @author LZD		2018/03/12
 */
/*
 * 为验证注解的继承而创建的父类
 */
package Annotation;

@Description("I am interface class Annotation...")
public class Person {

	@Description("I am interface method Annotation...")
	public String name() {
		return null;
	}
	
	public int age() {
		return 0;
	}
	
	@Deprecated   // 过时
	public void sing() {}
}
