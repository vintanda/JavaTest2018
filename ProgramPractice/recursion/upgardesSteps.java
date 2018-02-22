/**
 * @author LZD		2019/02/21
 */
/*
 * ��Դ��ţ���� ����ָOffer����8��
 * ��Ŀ������
 * 	һֻ����һ�ο�������1��̨�ף�Ҳ��������2��������Ҳ��������n����
 * 	�����������һ��n����̨���ܹ��ж���������
 * ˼·��
 * 	����һ�����̨�����������Ľ��������n��̨�׵Ĳ�ͬ����������f(n) = f(n-1) + f(n-2)
 * 	�Ӷ��Ƴ���̬��̨�׵�������������
 * 		��Ϊ��
 * 			n��̨�׵Ĳ�ͬ����������:f(n) = f(n-1) + f(n-2) +...+ f(2) + f(1)
 * 			n-1 ��̨�׵Ĳ�ͬ����������:f(n-1) = f(n-2) +...+ f(2) + f(1)
 * 		���ԣ�f(n) = f(n-1) + f(n-1) = 2*f(n-1) = 2*(n-1)
 */
package recursion;

public class upgardesSteps {

	/*
	 * �ݹ鷽ʽ��
	 * ����ʱ�䣺16ms
	 * ռ���ڴ棺8576k
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
	 * ѭ����ʽ
	 * ����ʱ�䣺18ms
	 * ռ���ڴ棺8684k
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
		
		//����˼���ǵݹ��ѭ���Ŀռ��ʱ�䶼ռ�õ���kkk...
		//�ݹ鷽������
		System.out.println("10floors,it needs " + JumpFloor(50));
		
		//ѭ����������
		System.out.println("10floors,it needs " + JumpFloor2(50));
	}
}
