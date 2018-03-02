/**
 * @author LZD		2018/02/27
 */
/*
 * 归并排序：
 * 时间复杂度：O(N*logN)，额外空间复杂度O(N)
 */
package class01;

public class mergeSort {

	public static void sort(int[] arr) {
		if(arr == null || arr.length < 2)
			return;
		sortProcess(arr, 0, arr.length-1);
	}
	
	//将数组排成两个有序的数组，使用插排递归实现
	public static void sortProcess(int[] arr, int L, int R) {
		if(L == R)
			return;
		//使用右移的位运算取mid
		int mid = L + ((L - R) >> 1);
		sortProcess(arr, L, mid);  //T(N/2)
		sortProcess(arr, mid+1, R);  //T(N/2)
		merge(arr, L, mid, R);  //O(N)
		//由上：T(N) = 2 T(N/2) + O(N)
	}
	
	//归并排序
	public static void merge(int[] arr, int L, int mid, int R) {
		//辅助数组
		int[] help = new int[R-L+1];
		int i = 0;
		int p1 = L;
		int p2 = mid + 1;
		
		//两个有序部分的数组还有数没有排的时候
		while(p1 <= mid && p2 <= R) {
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		
		//当其中一个数组的数已经全部放进去，将另外一个数组的没有放进去的部分放进去
		while(p1 <= mid) {
			help[i++] = arr[p1++];
		}
		while(p2 <= R) {
			help[i++] = arr[p2++];
		}
		
		//将辅助数组中的数全部放进原数组中
		for(i = 0;i < arr.length;i++) {
			arr[L + i] = help[i];
		}
	
	}
	
}
