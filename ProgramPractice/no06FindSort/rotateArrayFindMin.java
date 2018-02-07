/**
 * @author LZD		2018/02/07
 */
/*
 * 来源：牛客网
 * 《剑指Offer》	 第6题
 * 题目描述：
 * 		把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 
 * 		输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 		例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 *  	NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * 思路:
 * 		由题意：旋转数组是由两个递增序列组成的
 * 		第二个递增序列的第一个索引就是该数组中的最小数
 * 
 */
package no06FindSort;

public class rotateArrayFindMin {
	public int minNumberInRotateArray(int [] array) {
		if(array.length == 0)
			return 0;
		
		int index = 0;
		//找旋转部分的第一个索引
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
