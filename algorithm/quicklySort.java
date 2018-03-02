/**
 * @author LZD		2018/03/01
 */
/*
 * 随机快速排序
 * 时间复杂度：O(N*logN)，额外空间复杂度：O(logN)
 * 时间复杂度是由一个长期数学期望计算得出的
 * 额外空间复杂度是由记录边界的数组数量计算的，
 * 类似于将其一层一层二分出来的树的深度
 */
package class02;

public class quicklySort {

	public static void quickSort(int[] arr) {
		// 如果为空或长度为1不需要排序，直接返回
		if(arr == null || arr.length < 2)
			return;
		else
			quickSort(arr, 0, arr.length - 1);
	}
	
	// 递归排序
	public static void quickSort(int[] arr, int L, int R) {
		if(L < R) {
			/*
			 * 随机快排的随机就在这
			 * 是随机选取了一个数，和 R 进行了交换，然后使用这个数作为num，
			 * 所以每次选取的num是随机的，
			 * 在计算时间复杂度时，是没有最优最差情况的
			 * 而是通过一个长期的数学期望计算的，结果是O(N*logN)
			 */
			swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
			int[] border = partition(arr, L, R);
			
			// 小于区和大于区进行递归
			quickSort(arr, L, border[0] - 1);
			quickSort(arr, border[1] + 1, R);
		}
	}
	
	// 将给定数组划分为小于区、等于区和大于区
	public static int[] partition(int[] arr, int L, int R) {
		int num = arr[R];
		int less = L - 1;
		int more = R + 1;
		int curr = L;
		
		while(curr < more) {
			if(arr[curr] < num) {
				swap(arr, curr++, ++less);
			} else if(arr[curr] > num) {
				swap(arr, curr, --more);
			} else {
				curr++;
			}
		}
		
		return new int[] {less + 1, more - 1};
	}
	
	/*
	 * 老师写的：
	 * 取最后一个数作为num，这个方法是将num直接归在>num区中，
	 * 在划分之后再将最后位置上的与大于区的第一个进行交换，
	 * 就可以得到左边是小于区，中间是等于区，右边是大于区了
	 * emmm好处就是可以少一个变量kkk
	 */
	public static int[] partition2(int[] arr, int L, int R) {
		int less = L - 1;
		int more = R;
		
		while(L < more) {
			if(arr[L] < arr[R]) {
				swap(arr, L++, ++less);
			} else if(arr[L] > arr[R]) {
				swap(arr, L, --more);
			} else {
				L++;
			}
		}
		swap(arr, more, R);
		return new int[] {less + 1, more - 1};
	}
	
	// 交换
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	// for test 打印数组
	public static void printArray(int[] arr) {
		for(int i = 0;i < arr.length;i++) {
			System.out.print(arr[i] + "  ");
		}
		System.out.println();
	}

	// for test
	public static void main(String[] args) {
		int[] arr = {2, 1, 3, 6, 0, 5, 3, 4, 7, 0, 1, 2};
		quickSort(arr);
		printArray(arr);
	}
}
