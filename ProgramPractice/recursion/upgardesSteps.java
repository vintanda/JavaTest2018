/**
 * @author LZD		2019/02/21
 */
/*
 * 来源：牛客网 《剑指Offer》第8题
 * 题目描述：
 * 	一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 	求该青蛙跳上一个n级的台阶总共有多少种跳法
 * 思路：
 * 	从上一题的跳台阶问题的问题的解决方案：n级台阶的不同跳法的总数f(n) = f(n-1) + f(n-2)
 * 	从而推出变态跳台阶的问题解决方案：
 * 		因为：
 * 			n级台阶的不同跳法的总数:f(n) = f(n-1) + f(n-2) +...+ f(2) + f(1)
 * 			n-1 级台阶的不同跳法的总数:f(n-1) = f(n-2) +...+ f(2) + f(1)
 * 		所以：f(n) = f(n-1) + f(n-1) = 2*f(n-1) = 2*(n-1)
 */
package recursion;

public class upgardesSteps {

	/*
	 * 递归方式：
	 * 运行时间：16ms
	 * 占用内存：8576k
	 */
	public static int JumpFloor(int target) {
		if(target <= 0)
			return 0;
		else if(target == 1 || target == 2)
			return target;
		else
			return 2 * JumpFloor(target-1);
	}
	
	/*
	 * 循环方式
	 * 运行时间：18ms
	 * 占用内存：8684k
	 */
	public static int JumpFloor2(int target) {
		if(target <= 0)
			return 0;
		else if(target == 1 || target == 2)
			return target;
		else {
			int stepSum = 0;
			int stepSumBack = 2;
			for(int i = 3;i <= target;i++) {
				stepSum = stepSumBack * 2;
				stepSumBack = stepSum;
			}
			return stepSum;
		}
	}
	
	
	public static void main(String[] args) {
		
		//有意思的是递归比循环的空间和时间都占用的少kkk...
		//递归方法调用
		System.out.println("10floors,it needs " + JumpFloor(50));
		
		//循环方法调用
		System.out.println("10floors,it needs " + JumpFloor2(50));
	}
}
