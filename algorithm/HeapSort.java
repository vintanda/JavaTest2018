/**
 * @author LZD		2018/03/01
 */
/*
 * 堆排序
 * 1.将给定的数组构造成一个完全二叉树
 * 2.将这个完全二叉树构造成一个大根堆(大顶堆)
 * 3.取这个大顶堆的顶和最后一个数进行交换
 * 4.交换后的堆大小--，并且将堆再排成一个大顶堆
 * 5.回到3
 * 终止条件：堆的大小为0的时候停止
 */
package class02;

public class HeapSort {

	public static void heapSort(int[] arr) {
		if(arr == null || arr.length < 2)
			return;
		
		// 构建大顶堆
		for(int i = 0;i < arr.length;i++) {
			heapInsert(arr, i);
		}
		
		int heapSize = arr.length;
		swap(arr, 0, --heapSize);
		while(heapSize > 0) {
			heapify(arr, 0, heapSize);
			swap(arr, 0, --heapSize);
		}
	}
	
	// 插入数使其形成大顶堆
	public static void heapInsert(int[] arr, int index) {
		while(arr[index] > arr[(index - 1)/2]) {
			swap(arr, index, (index - 1)/2);
			index = (index - 1)/2;
		}
	}
	
	// 将堆化为大顶堆
	public static void heapify(int[] arr, int index, int heapSize) {
		// 先判断当前的index位置的结点是否是叶子结点
		int left = index * 2 + 1;
		
		while(left < heapSize) {
			// 不是叶子结点则选出index位置结点的孩子结点中较大的赋给largest
			int largest = left+1 < heapSize && arr[left + 1] > arr[left]
					? left + 1: left;
			largest = arr[largest] > arr[index] ? largest : index;
			if(largest == index) {
				break;
			}
			swap(arr, largest, index);
			index = largest;
			left = index * 2 + 1;
		}
	}
	
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
		int[] arr = {2, 1, 3, 6, 0, 5};
		heapSort(arr);
		printArray(arr);
	}
}
