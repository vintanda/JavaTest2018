/**
 * @author LZD		2018/02/07
 */
/*
 * ��Դ��ţ����
 * ����ָOffer��	 ��6��
 * ��Ŀ������
 * 		��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת�� 
 * 		����һ���ǵݼ�����������һ����ת�������ת�������СԪ�ء�
 * 		��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1��
 *  	NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��
 * ˼·:
 * 		�����⣺��ת����������������������ɵ�
 * 		�ڶ����������еĵ�һ���������Ǹ������е���С��
 * 
 */
package no06FindSort;

public class rotateArrayFindMin {
	public int minNumberInRotateArray(int [] array) {
		if(array.length == 0)
			return 0;
		
		int index = 0;
		//����ת���ֵĵ�һ������
		for(int i = 0;i < array.length;i++) {
			if(array[i] > array[i+1]) {
				index = i+1;
				break;
			}
		}
		return array[index];
		
    }
	
	public static void main(String[] args) {
		int[] array = new int[] {3,4,5,1,2};
		System.out.println(new rotateArrayFindMin().minNumberInRotateArray(array));
	}
}
