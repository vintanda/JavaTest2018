/**
 * @author LZD		2018/02/07
 */
/*
 * 来源：牛客网
 * 《剑指Offer》 第5题
 * 题目描述：
 * 	用两个栈来实现一个队列，完成队列的Push和Pop操作。 
 * 	队列中的元素为int类型。
 * 思路：
 * 	栈：先进后出
 *  队列：先进先出
 *  两个栈 -> 队列：
 *  		将元素push到stack1中，
 *  		再将元素从stack1 pop到Stack2中，
 *  		最后将元素从stack2中pop出来
 */
package stackList;

import java.util.Stack;

public class doubleStackToAList {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
        if(stack2.empty()) {
        	//-1是stack2为空时的标志
        	if(stack1.empty()) 
        		return -1;
        	else {
        		while(!stack1.empty()) {
        			stack2.push(stack1.pop());
        		}
        	}
        }
        return stack2.pop();
    }
    
    public static void main(String[] args) {
		doubleStackToAList obj = new doubleStackToAList();
		
		//添加元素
		obj.push(1);
		obj.push(2);
		obj.push(3);
		obj.push(4);
		
		//取出元素
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		
	}
}
