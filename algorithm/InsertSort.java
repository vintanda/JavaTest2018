/**
 * @author LZD		2018/02/27
 */
/*
 * ��������
 * ʱ�临�Ӷȣ�
 * �Ǻ����ݵ�״���йص��㷨���̣�һ�ɰ������״������
 * ���ţ��������У�O(N)
 * ���������У�O(N^2)
 * ����ʱ�临�Ӷ�Ϊ��O(N^2)
 */
package class01;

public class InsertSort {

	public static void sort(int[] arr) {
		if(arr == null || arr.length < 2)
			return;
		
		//iλ���ϵ��������������Ҫ�ŵ���
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
		 * ��ʹ��λ������н���
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
