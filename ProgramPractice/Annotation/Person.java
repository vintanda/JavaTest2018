/**
 * @author LZD		2018/03/12
 */
/*
 * Ϊ��֤ע��ļ̳ж������ĸ���
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
	
	@Deprecated   // ��ʱ
	public void sing() {}
}
