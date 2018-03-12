/**
 * @author LZD		2018/03/11
 */
/*
 * 动态加载类的方式
 * 该类是一个实现了OfficeAble接口的类，实现了该接口的类实现了统一标准
 */
package reflect;

class Word implements OfficeAble {
	public void start() {
		System.out.println("Word...start...");
	}
}