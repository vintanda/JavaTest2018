/**
 * @Author LZD
 * @Date 2018/07/03
 *
 * 题目描述:
 *  在数组中的两个数字,如果前面一个数字大于后面的数字,则这两个数字组成一个逆序对.
 *  输入一个数组,求出这个数组中的逆序对的总数P.
 *  并将P对1000000007取模的结果输出,即输出P%1000000007
 *
 * 输入描述:
 *  题目保证输入的数组中没有的相同的数字
 *
 * 数据范围：
 *  对于%50的数据,size<=10^4
 *  对于%75的数据,size<=10^5
 *  对于%100的数据,size<=2*10^5
 *
 * 示例1:
 *  输入:1,2,3,4,5,6,7,0
 *  输出:7
 *
 * 思路：
 * http://note.youdao.com/noteshare?id=5cbc73665640ad4dede49daa8997a9b0
 *  大体上就是一个二分然后归并的思路,不是每一个数都和后面所有的数进行比较,这样的时间复杂度是O(N^2),
 *  而是将其分成子数组的形式,子数组是排好序的状态,
 *  最小划分子数组是长度为1,和相邻的子数组进行比较,
 *  如果前面的比后面的大,那么就认为这是一对逆序,
 *  每个子数组都有一个指针,指向当前子数组最大的数,
 *  如果子数组a当前的数比子数组b当前的数大,
 *  那就是说子数组a比子数组b当前的数以及子数组b中比当前数小的数都大(可以使用下标进行个数的计算)
 *
 * 总体过程就是：
 *      将一个数组二分到最小,然后进行归并排序,同时统计逆序对的个数
 *
 * 性能：
 *  emmmm这次的方法太多了,调来调去的,最后由于权限的因素没有在牛客上成功跑下来,但是这个代码是可以使用的!
 *  【这个题本质上挺简单的但是折腾了好久...不过这个统计逆序对的方法很nice
 */
package forOffer3;

public class inversePairs {

    private static inversePairs inversePairs = new inversePairs();
    // 统计逆序对
    private long cnt = 0;

    // 创建辅助数组
    private int[] tmp;

    public static void main(String[] args) {
        System.out.println(inversePairs.InversePairs(new int[]{1,2,3,4,5,6,7,0}));
    }

    public int InversePairs(int [] arr) {
        if(null == arr || 0 == arr.length)
            return 0;
        tmp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1);
        return (int)(cnt % 1000000007);
    }

    private static void mergeSort(int[] arr, int l, int r) {
        if(r - l < 1)
            return;
        int m = l + (r - l)/2;
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);
        inversePairs.merge(arr, l, m, r);
    }

    private void merge(int[] arr, int l, int m, int r) {
        int i = m, j = r, k = r;
        while(i >= l || j >= m + 1) {
            if(i < l)
                tmp[k--] = arr[j--];
            else if(j < m + 1)
                tmp[k--] = arr[i--];
            else if(arr[i] > arr[j]) {
                System.out.println("arr[i]" + arr[i]);
                System.out.println("arr[j]" + arr[j]);
                // 是一个逆序对
                tmp[k--] = arr[i--];
                cnt += j - (m + 1) + 1;
            }else if(arr[i] < arr[j])
                tmp[k--] = arr[j--];
        }

        // 复制回原数组
        for(k = l; k <= r; k++) {
            arr[k] = tmp[k];
        }

    }
}



