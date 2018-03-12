/**
 * @author LZD		2018/03/11
 */
/*
 * 动态加载类的方式
 * 该类是一个调用其他类的，使用的是静态加载
 */
package reflect;

class Office {
	public static void main(String[] args) {
		/*
		 * new创建对象是类的静态加载，在编译时刻就要加载需要用到的类
		 * 通过动态加载可以解决该问题
		 * 因为有的类可能此时是不会使用的，所以暂时还不需要实现；
		 * 如果要使用其他的功能就无法实现，所以使用动态加载类，
		 * 在需要的时候再进行加载，再补充需要的部分
		 */
		
		if("Word".equals(args[0])) {
			Word w = new Word();
			w.start();
		}
//		if("Excel".equals(args[1])) {
//			Excel e = new Excel();
//			e.start();
//		}
	}
}