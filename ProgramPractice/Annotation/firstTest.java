/**
 * @author LZD		2018/03/10
 */
/*
 * 三种基本注解：Override、Deprecated和SuppressWarnings
 */
package Annotation;

public class firstTest {

	public final int a = 1;
	
	public firstTest() {
		System.out.println("firstTest");
	}	
	
	public static void mian(String[] args) {
		// TODO Auto-generated method stub
		firstTest ft = new firstTest();
		// a = 0;
		final father f = new father();
		f.say();
		// f = new father();
	}

}

class father {
	
	private String name = "kkk";
	
	public void say() {
		System.out.println("i am your father");
	}
	
	@SuppressWarnings("unused")  // 不警告过时
	@Deprecated    // 过时
	private void info() {
		// TODO Auto-generated method stub
		System.out.println("my name is " + name);
	}
	
}

class son extends father {

	@Override
	public void say() {
		// TODO Auto-generated method stub
		super.say();
	}
	
	@SuppressWarnings("unused")
	// @Override
	private void info() {
		System.out.println("该方法不是重写的方法");
	}
	
}

