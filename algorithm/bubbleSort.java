/**
 * @author LZD		2018/02/26
 */
/*
 * 冒泡排序
 * 时间复杂度：O(N^2)，额外空间复杂度：O(1)
 */
package class01;

import java.util.Arrays;

public class bubbleSort {
	
	public static void sort(int[] arr) {
		if(arr == null || arr.length < 2)
			return;
		for(int end = arr.length-1;end > 0;end--) {
			for(int i = 0;i < end;i++) {
				if(arr[i] > arr[i+1]) {
					swap(arr, i, i+1);
				}
			}
		}
	}
	
	public static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

	// for test 一个绝对正确的方法
	public static void rightMethod(int[] arr) {
		Arrays.sort(arr);
	}
	
	// for test 随机数组生成器
	/*
	 * Math.random() -> double[0,1)
	 * (int) ((size + 1) * Math.random()) -> [0, size]
	 * size = 6, size + 1 = 7
	 * Math.random() -> [0,1) * 7 -> [0,7)double
	 * double -> int[0,6] -> int
	 */
	public static int[] generateRandomArray(int size, int value) {
		//产生的数组长度是[0, size]
		int[] arr = new int[(int) ((size + 1) * Math.random())];
		
		//产生的数组中的数的范围是-value ~ value
		for(int i = 0;i < arr.length;i++) {
			arr[i] = (int) ((value + 1) * Math.random()
					- (int) (value * Math.random()));
		}
		return arr;
	}
	
	// for test 复制数组
	public static int[] copyArray(int[] arr) {
		if(arr == null)
			return null;
		int[] res = new int[arr.length];
		for(int i = 0;i < arr.length;i++) {
			res[i] = arr[i];
		}
		return res;
	}
	
	//判断两个数组是否相等
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null))
			return false;
		if(arr1 == null && arr2 == null)
			return true;
		if(arr1.length != arr2.length)
			return false;
		for(int i = 0;i < arr1.length;i++) {
			if(arr1[i] != arr2[i])
				return false;
		}
		return true;
	}
	
	//打印数组
	private static void printArray(int[] arr) {
		if(arr == null)
			return;
		for(int i = 0;i < arr.length;i++) {
			System.out.println(arr[i]);
		}
		
	}
	
	public static void main(String[] args) {
		int testTime = 500000;
		int size = 10;
		int value = 100;
		boolean succeed = true;
		
		for(int i = 0;i < testTime;i++) {
			int[] arr1 = generateRandomArray(size, value);
			int[] arr2 = copyArray(arr1);
			int[] arr3 = copyArray(arr1);
			sort(arr1);
			rightMethod(arr2);
			if(!isEqual(arr1, arr2)) {
				succeed = false;
				printArray(arr3);
				break;
			}
		}
		System.out.println(succeed ? "succeed!" : "false..");
	}
	
}
