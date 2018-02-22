/**
 * @author LZD		2019/02/22
 */
/*
 * 来源：牛客网 《剑指Offer》 第9题
 * 题目描述：
 * 	我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 	请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 思路：
 * 	http://note.youdao.com/noteshare?id=0ad2b2cff9b761173ba7e7dd6eb238d2
 */
package recursion;

public class rectCover {
	
	/*
	 * 递归
	 * 运行时间：533ms
	 * 占用内存：8820k
	 */
	public static int cover(int target) {
		if(target <= 0)
            return 0;
        else if(target == 1 || target == 2)
            return target;
        else
            return (cover(target-1) + cover (target-2));
	}
	
	/*
	 * 循环
	 * 运行时间：18ms
	 * 占用内存：8616k
	 */
	public static int cover2(int target) {
		if(target <= 0)
            return 0;
        else if(target == 1 || target == 2)
            return target;
        else {
        	int sum = 0;
        	int sumBack1 = 2;
        	int sumBack2 = 1;
        	for(int i = 3;i <= target;i++) {
        		sum = sumBack1 + sumBack2;
        		sumBack2 = sumBack1;
        		sumBack1 = sum;
        	}
        	return sum;
        }
		
	}
	
	
	public static void main(String[] args) {
		System.out.println("10个2*1组成2*10的大矩形的方法有" + cover(10) + "种");
		System.out.println("10个2*1组成2*10的大矩形的方法有" + cover2(10) + "种");
	}
	
	
	
}
