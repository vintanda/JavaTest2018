/**
 * @author LZD		2018/03/11
 */
/*
 * 动态加载类的方式
 * 该类是一个调用其他类的，使用的是动态加载
 */
package reflect;

import java.util.Scanner;

class OfficeBetter {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		try {
			// 动态加载类，在运行时刻加载   注：forName参数传入的是完整路径
			Class c = Class.forName(input);
			/*
			 * 通过类类型，创建该类对象
			 * 从之前的学习我们知道使用newInstance创建后并进行强制转换，
			 * 如果要加载的类与代码中强制转换的类型不同怎么办？
			 * 我们在这使用一个Word和Excel的统一标准OfficeAble(Word和Excel都实现该接口)
			 */
			 OfficeAble oa = (OfficeAble)c.newInstance();
			 oa.start();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}