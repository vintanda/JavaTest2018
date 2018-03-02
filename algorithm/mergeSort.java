/**
 * @author LZD		2018/02/27
 */
/*
 * �鲢����
 * ʱ�临�Ӷȣ�O(N*logN)������ռ临�Ӷ�O(N)
 */
package class01;

public class mergeSort {

	public static void sort(int[] arr) {
		if(arr == null || arr.length < 2)
			return;
		sortProcess(arr, 0, arr.length-1);
	}
	
	//�������ų�������������飬ʹ�ò��ŵݹ�ʵ��
	public static void sortProcess(int[] arr, int L, int R) {
		if(L == R)
			return;
		//ʹ�����Ƶ�λ����ȡmid
		int mid = L + ((L - R) >> 1);
		sortProcess(arr, L, mid);  //T(N/2)
		sortProcess(arr, mid+1, R);  //T(N/2)
		merge(arr, L, mid, R);  //O(N)
		//���ϣ�T(N) = 2 T(N/2) + O(N)
	}
	
	//�鲢����
	public static void merge(int[] arr, int L, int mid, int R) {
		//��������
		int[] help = new int[R-L+1];
		int i = 0;
		int p1 = L;
		int p2 = mid + 1;
		
		//�������򲿷ֵ����黹����û���ŵ�ʱ��
		while(p1 <= mid && p2 <= R) {
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		
		//������һ����������Ѿ�ȫ���Ž�ȥ��������һ�������û�зŽ�ȥ�Ĳ��ַŽ�ȥ
		while(p1 <= mid) {
			help[i++] = arr[p1++];
		}
		while(p2 <= R) {
			help[i++] = arr[p2++];
		}
		
		//�����������е���ȫ���Ž�ԭ������
		for(i = 0;i < arr.length;i++) {
			arr[L + i] = help[i];
		}
	
	}
	
}
