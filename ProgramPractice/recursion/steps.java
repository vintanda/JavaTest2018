/**
 * @author LZD		2019/02/20
 */
/*
 * 来源：牛客网 《剑指Offer》第7题
 * 题目描述：
 * 	一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 	求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 思路：
 * 		这个题其实是一个斐波那契数列，
 * 		可以把n级台阶时的跳法看成是n的函数，记为f(n)。
 * 		当n>2时，第一次跳的时候就有两种不同的选择：
 * 			一是第一次只跳1级，此时跳法数目等于后面剩下的n-1级台阶的跳法数目，即为f(n-1);
 * 			另一种选择是第一次跳2级，此时跳法数目等于后面剩下n-2级台阶的跳法数目，即为f(n-2)。
 * 		因此，n级台阶的不同跳法的总数f(n)=f(n-1)+f(n-2)。
 * 		分析到这里，不难看出这实际上就是斐波那契数列了。
 * 
 * 代码实现：
 * 	递归：
 * 		对于第n个台阶来说，只能从n-1或者n-2的台阶跳上来，所以
 * 		F(n) = F(n-1) + F(n-2)
 * 		斐波拉契数序列，初始条件
 * 		n=1:只能一种方法
 * 		n=2:两种
 * 		递归一下就好了
 * 	迭代：
 * 		当前台阶的跳法总数 = 当前台阶后退一阶的台阶的跳法总数 + 当前台阶后退二阶的台阶的跳法总数
 */
package recursion;

public class steps {

	public static void main(String[] args) {
		System.out.println("target = 10");
		System.out.println("result: " + JumpFloor(10));
	}
	
	public static int JumpFloor(int target) {
		if(target == 1 || target == 2) 
			return target;
		
		int jumpSum = 0;
		int jumpSumBackStep1 = 2;
		int jumpSumBackStep2 = 1;
		
		for(int i = 3;i < target;i++) {
			System.out.println("现在是第" + target + "阶，有" + jumpSum + "种跳法");
			jumpSum = jumpSumBackStep1 + jumpSumBackStep2;
			jumpSumBackStep2 = jumpSumBackStep1;
			jumpSumBackStep1 = jumpSum;
		}
		
		return jumpSum;
	}
	
	public static int JumpFloor2(int target) {
		if(target <= 0)
			return 0;
		else if(target == 1 || target == 2)
			return target;
		else
			return JumpFloor2(target-1) + JumpFloor2(target-2);
	}
}
