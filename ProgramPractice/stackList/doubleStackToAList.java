/**
 * @author LZD		2018/02/07
 */
/*
 * ��Դ��ţ����
 * ����ָOffer�� ��5��
 * ��Ŀ������
 * 	������ջ��ʵ��һ�����У���ɶ��е�Push��Pop������ 
 * 	�����е�Ԫ��Ϊint���͡�
 * ˼·��
 * 	ջ���Ƚ����
 *  ���У��Ƚ��ȳ�
 *  ����ջ -> ���У�
 *  		��Ԫ��push��stack1�У�
 *  		�ٽ�Ԫ�ش�stack1 pop��Stack2�У�
 *  		���Ԫ�ش�stack2��pop����
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
        	//-1��stack2Ϊ��ʱ�ı�־
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
		
		//���Ԫ��
		obj.push(1);
		obj.push(2);
		obj.push(3);
		obj.push(4);
		
		//ȡ��Ԫ��
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		
	}
}
