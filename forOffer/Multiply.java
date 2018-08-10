/**
 * @Date 2018/08/06
 * @Author LZD
 *
 * 题目描述：
 *  给定一个数组A[0,1,...,n-1], 请构建一个数组B[0,1,...,n-1],
 *  其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1].
 *  不能使用除法.
 *
 * 思路：
 *  看讨论区很多从两遍累乘的做法...觉得emmm很没必要...
 *  就到相等的时候跳过就好了啊...
 *  也有看到动态规划的..没看懂..
 *
 * 运行性能：
 *  运行时间：13ms
 *  占用内存：9280k
 */
package forOffer4;

public class Multiply {
    public static void main(String[] args) {
        int[] A = new int[]{2, 4, 6, 8};
        new Multiply().multiply(A);
    }
    public int[] multiply(int[] A) {
        if(A == null)
            return null;
        if(A.length == 0)
            return null;
        int len = A.length;
        int[] B = new int[len];
        for(int i = 0;i < len;i++) {
            int tmp = 1;
            for(int j = 0;j < len;j++) {
                if(i == j)
                    continue;
                tmp *= A[j];
            }
            B[i] = tmp;
        }
//        for (int num : B) {
//            System.out.println(num);
//        }
        return B;
    }
}
