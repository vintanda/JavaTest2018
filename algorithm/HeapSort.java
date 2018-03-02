/**
 * @author LZD		2018/03/01
 */
/*
 * ������
 * 1.�����������鹹���һ����ȫ������
 * 2.�������ȫ�����������һ�������(�󶥶�)
 * 3.ȡ����󶥶ѵĶ������һ�������н���
 * 4.������ĶѴ�С--�����ҽ������ų�һ���󶥶�
 * 5.�ص�3
 * ��ֹ�������ѵĴ�СΪ0��ʱ��ֹͣ
 */
package class02;

public class HeapSort {

	public static void heapSort(int[] arr) {
		if(arr == null || arr.length < 2)
			return;
		
		// �����󶥶�
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
	
	// ������ʹ���γɴ󶥶�
	public static void heapInsert(int[] arr, int index) {
		while(arr[index] > arr[(index - 1)/2]) {
			swap(arr, index, (index - 1)/2);
			index = (index - 1)/2;
		}
	}
	
	// ���ѻ�Ϊ�󶥶�
	public static void heapify(int[] arr, int index, int heapSize) {
		// ���жϵ�ǰ��indexλ�õĽ���Ƿ���Ҷ�ӽ��
		int left = index * 2 + 1;
		
		while(left < heapSize) {
			// ����Ҷ�ӽ����ѡ��indexλ�ý��ĺ��ӽ���нϴ�ĸ���largest
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

	// for test ��ӡ����
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
