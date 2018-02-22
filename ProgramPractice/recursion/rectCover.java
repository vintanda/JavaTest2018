/**
 * @author LZD		2019/02/22
 */
/*
 * ��Դ��ţ���� ����ָOffer�� ��9��
 * ��Ŀ������
 * 	���ǿ�����2*1��С���κ��Ż�������ȥ���Ǹ���ľ��Ρ�
 * 	������n��2*1��С�������ص��ظ���һ��2*n�Ĵ���Σ��ܹ��ж����ַ�����
 * ˼·��
 * 	http://note.youdao.com/noteshare?id=0ad2b2cff9b761173ba7e7dd6eb238d2
 */
package recursion;

public class rectCover {
	
	/*
	 * �ݹ�
	 * ����ʱ�䣺533ms
	 * ռ���ڴ棺8820k
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
	 * ѭ��
	 * ����ʱ�䣺18ms
	 * ռ���ڴ棺8616k
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
		System.out.println("10��2*1���2*10�Ĵ���εķ�����" + cover(10) + "��");
		System.out.println("10��2*1���2*10�Ĵ���εķ�����" + cover2(10) + "��");
	}
	
	
	
}
