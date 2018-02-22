/**
 * @author LZD		2018/02/08
 */
/*
 * 来源：牛客网	《剑指Offer》第7题
 * 题目描述：
 * 		大家都知道斐波那契数列，现在要求输入一个整数n，
 * 		请你输出斐波那契数列的第n项。n<=39
 * 思路：
 * 		斐波那契数列是一个经典算法题，
 * 		0,1,1,2,3,5,8,13,...前两个数是0和1，从第三个数开始是前两个数之和。
 * 		这次的收获是，
 * 		1.以前学的时候都是用递归写的，一开始也是用递归写的，
 * 		在讨论区看到大佬们都说建议循环写，因为递归可能会导致内存溢出，
 * 		于是又用循环写了一次，相比之下，控制循环的条件很明确就要求我们对数列更熟悉了
 * 		2.递归会导致内存溢出的原因。是因为递归是栈，
 * 		如果递归调的过深，内存无法释放就有可能导致内存溢出
 */
package recursion;

public class FibonacciTest {
	
	//递归实现
    public int FibonacciDG(int n) {
        if(n == 0)
            return 0;
        else if(n == 1)
            return 1;
        else
            return (FibonacciDG(n-2) + FibonacciDG(n-1));
    }
    
    //循环实现
    public int FibonacciXH(int n) {
    	if(n == 0)
    		return 0;
    	if(n == 1 || n == 2)
    		return 1;
    	else {
    		int f1 = 0;
    		int f2 = 1;
    		for(int i = 1;i < n;i++) {
    			int temp = f1;
    			f1 = f2;
    			f2 = temp + f2;
    		}
    		return f2;
    	}
    }
    
    //调用函数
    public static void main(String[] args) {
		System.out.println("递归实现：" + new FibonacciTest().FibonacciDG(9));
		System.out.println("循环实现：" + new FibonacciTest().FibonacciXH(9));
	}
}
