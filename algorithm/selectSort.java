/**
 * @author LZD		2018/02/26
 */
/*
 * 选择排序
 * 时间复杂度：O(N^2)，额外空间复杂度：O(1)
 */
package class01;

public class selectSort {

	public static void sort(int[] arr) {
		if(arr == null || arr.length < 2)
			return;
		for(int i = 0;i < arr.length;i++) {
			int minIndex = i;
			for(int j = i+1;j < arr.length;j++) {
				minIndex = arr[j] < arr[i] ? j : minIndex;
			}
			swap(arr, i, minIndex);
		}
	}
	
	public static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
	
	public static void main(String[] args) {
		
	}
}
