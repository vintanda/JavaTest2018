/**
 * @author LZD		2018/02/08
 */
/*
 * ��Դ��ţ����	����ָOffer����7��
 * ��Ŀ������
 * 		��Ҷ�֪��쳲��������У�����Ҫ������һ������n��
 * 		�������쳲��������еĵ�n�n<=39
 * ˼·��
 * 		쳲�����������һ�������㷨�⣬
 * 		0,1,1,2,3,5,8,13,...ǰ��������0��1���ӵ���������ʼ��ǰ������֮�͡�
 * 		��ε��ջ��ǣ�
 * 		1.��ǰѧ��ʱ�����õݹ�д�ģ�һ��ʼҲ���õݹ�д�ģ�
 * 		�����������������Ƕ�˵����ѭ��д����Ϊ�ݹ���ܻᵼ���ڴ������
 * 		��������ѭ��д��һ�Σ����֮�£�����ѭ������������ȷ��Ҫ�����Ƕ����и���Ϥ��
 * 		2.�ݹ�ᵼ���ڴ������ԭ������Ϊ�ݹ���ջ��
 * 		����ݹ���Ĺ���ڴ��޷��ͷž��п��ܵ����ڴ����
 */
package recursion;

public class FibonacciTest {
	
	//�ݹ�ʵ��
    public int FibonacciDG(int n) {
        if(n == 0)
            return 0;
        else if(n == 1)
            return 1;
        else
            return (FibonacciDG(n-2) + FibonacciDG(n-1));
    }
    
    //ѭ��ʵ��
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
    
    //���ú���
    public static void main(String[] args) {
		System.out.println("�ݹ�ʵ�֣�" + new FibonacciTest().FibonacciDG(9));
		System.out.println("ѭ��ʵ�֣�" + new FibonacciTest().FibonacciXH(9));
	}
}
