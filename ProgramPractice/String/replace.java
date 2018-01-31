/**
 * @author LZD		2019/01/31
 */
package String;
/*
* 链接：https://www.nowcoder.com/questionTerminal/4060ac7e3e404ad1a894ef3e17650423
* 来源：牛客网
* 问题1：替换字符串，是在原来的字符串上做替换，还是新开辟一个字符串做替换！
* 问题2：在当前字符串替换，怎么替换才更有效率（不考虑java里现有的replace方法）。
*      从前往后替换，后面的字符要不断往后移动，要多次移动，所以效率低下
*      从后往前，先计算需要多少空间，然后从后往前移动，则每个字符只为移动一次，这样效率更高一点。
*/
/*
 * 做这道题的过程：
 * 第一次：将StringBuffer转换成String，将String用空格作为分割条件分为String[]，
 * 		再将数组中的元素拼接起来。之后考虑到多个空格以及最后面的空格无法识别改了
 * 第二次：这个用到了ArrayList。
 * 		第一步还是转换，然后使用toCharArray()方法将其转换为char[]，遍历数组判断是否为空格
 * 		若是空格，则将当前的index保存到new的ArrayList中，
 * 		最后再遍历一次数组，将数组下标和ArrayList中保存的下标进行比对，看是否当前为空格
 * 		但是由于编译环境不认ArrayList并且只是一个函数无法添加包所以...
 * 第三次：将ArrayList替换成了int[]，相对来说麻烦了不少
 * 最后在讨论区看到有人说一行代码就结束了但是编译环境不允许..
 * 		使用return str.toString().replaceAll(" " , "%20");
 * 		将字符串中所有空格替换为"%20"...
 * 		真的很方便，对API不熟悉真的要好好学，这么方便的方法为什么不用【捂脸】
 */
import java.util.ArrayList;
import java.util.Scanner;

public class replace {
	public String replaceSpace(StringBuffer str) {
		
		//使用String(StringBuffer buffer);构造方法将StringBuffer对象转换为String对象
		String s = new String(str);
		String newString = "";
		//ArrayList<Integer> list = new ArrayList<>();
		char[] chars = s.toCharArray();
		int list[] = new int[chars.length];
		for(int i : list) {
			list[i++] = chars.length;
		}

		for(int i = 0,j = 0;i < chars.length;i++) {
			if(chars[i] == ' ')
				//list.add(i);
				list[j++] = i;
		}
		for(int i = 0,j = 0;(i < chars.length) && (j < list.length);i++) {
			if(i == list[j]) {
				//空格
				newString = newString + "%20";
				j++;
			}else {
				//不是空格
				newString += chars[i];
			}
		}
		
    	return newString;
    	
    	//return str.toString().replaceAll(" " , "%20");
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		//使用StringBuffer(String str);构造方法将String对象转换为StringBuffer对象
		StringBuffer buffer = new StringBuffer(s);
		s = new replace().replaceSpace(buffer);
		System.out.println(s);
	}
}
