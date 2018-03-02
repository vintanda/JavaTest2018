/**
 * @author LZD		2018/03/01
 */
/*
 * �����������
 * ʱ�临�Ӷȣ�O(N*logN)������ռ临�Ӷȣ�O(logN)
 * ʱ�临�Ӷ�����һ��������ѧ��������ó���
 * ����ռ临�Ӷ����ɼ�¼�߽��������������ģ�
 * �����ڽ���һ��һ����ֳ������������
 */
package class02;

public class quicklySort {

	public static void quickSort(int[] arr) {
		// ���Ϊ�ջ򳤶�Ϊ1����Ҫ����ֱ�ӷ���
		if(arr == null || arr.length < 2)
			return;
		else
			quickSort(arr, 0, arr.length - 1);
	}
	
	// �ݹ�����
	public static void quickSort(int[] arr, int L, int R) {
		if(L < R) {
			/*
			 * ������ŵ����������
			 * �����ѡȡ��һ�������� R �����˽�����Ȼ��ʹ���������Ϊnum��
			 * ����ÿ��ѡȡ��num������ģ�
			 * �ڼ���ʱ�临�Ӷ�ʱ����û��������������
			 * ����ͨ��һ�����ڵ���ѧ��������ģ������O(N*logN)
			 */
			swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
			int[] border = partition(arr, L, R);
			
			// С�����ʹ��������еݹ�
			quickSort(arr, L, border[0] - 1);
			quickSort(arr, border[1] + 1, R);
		}
	}
	
	// ���������黮��ΪС�������������ʹ�����
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
	 * ��ʦд�ģ�
	 * ȡ���һ������Ϊnum����������ǽ�numֱ�ӹ���>num���У�
	 * �ڻ���֮���ٽ����λ���ϵ���������ĵ�һ�����н�����
	 * �Ϳ��Եõ������С�������м��ǵ��������ұ��Ǵ�������
	 * emmm�ô����ǿ�����һ������kkk
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
	
	// ����
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
		int[] arr = {2, 1, 3, 6, 0, 5, 3, 4, 7, 0, 1, 2};
		quickSort(arr);
		printArray(arr);
	}
}
