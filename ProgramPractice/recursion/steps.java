/**
 * @author LZD		2019/02/20
 */
/*
 * ��Դ��ţ���� ����ָOffer����7��
 * ��Ŀ������
 * 	һֻ����һ�ο�������1��̨�ף�Ҳ��������2����
 * 	�����������һ��n����̨���ܹ��ж�����������
 * ˼·��
 * 		�������ʵ��һ��쳲��������У�
 * 		���԰�n��̨��ʱ������������n�ĺ�������Ϊf(n)��
 * 		��n>2ʱ����һ������ʱ��������ֲ�ͬ��ѡ��
 * 			һ�ǵ�һ��ֻ��1������ʱ������Ŀ���ں���ʣ�µ�n-1��̨�׵�������Ŀ����Ϊf(n-1);
 * 			��һ��ѡ���ǵ�һ����2������ʱ������Ŀ���ں���ʣ��n-2��̨�׵�������Ŀ����Ϊf(n-2)��
 * 		��ˣ�n��̨�׵Ĳ�ͬ����������f(n)=f(n-1)+f(n-2)��
 * 		������������ѿ�����ʵ���Ͼ���쳲����������ˡ�
 * 
 * ����ʵ�֣�
 * 	�ݹ飺
 * 		���ڵ�n��̨����˵��ֻ�ܴ�n-1����n-2��̨��������������
 * 		F(n) = F(n-1) + F(n-2)
 * 		쳲����������У���ʼ����
 * 		n=1:ֻ��һ�ַ���
 * 		n=2:����
 * 		�ݹ�һ�¾ͺ���
 * 	������
 * 		��ǰ̨�׵��������� = ��ǰ̨�׺���һ�׵�̨�׵��������� + ��ǰ̨�׺��˶��׵�̨�׵���������
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
			System.out.println("�����ǵ�" + target + "�ף���" + jumpSum + "������");
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
