/**
 * @author LZD		2018/02/27
 */
/*
 * 插入排序
 * 时间复杂度：
 * 是和数据的状况有关的算法流程，一律按照最差状况计算
 * 最优：有序序列：O(N)
 * 最差：逆序序列：O(N^2)
 * 所以时间复杂度为：O(N^2)
 */
package class01;

public class InsertSort {

	public static void sort(int[] arr) {
		if(arr == null || arr.length < 2)
			return;
		
		//i位置上的数就是这次排序要排的数
		for(int i = 1;i < arr.length;i++) {
			for(int j = i-1;j >= 0 && arr[j] > arr[j+1];j--) {
				swap(arr, j, j+1);
			}
		}
	}
	
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
		/*
		 * 或使用位运算进行交换
		 * arr[i] = arr[i] ^ arr[j];
		 * arr[j] = arr[i] ^ arr[j];
		 * arr[i] = arr[i] ^ arr[j];
		 */
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {2,3,1,6,5,9};
		sort(arr);
		for(int i = 0;i < arr.length;i++)
			System.out.println(arr[i]);
	}
	
}
