/**
 * @Author LZD
 * @Date 2018/06/12
 *
 * 题目描述:
 *  HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学.
 *  今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,
 *  当向量全为正数的时候,问题很好解决.
 *  但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢?
 *  例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止).
 *  你会不会被他忽悠住?(子向量的长度至少是1)
 *
 * 思路：
 *  在这之前先吐槽一下题啊...这种无聊的程序员就应该扔出去..ok回到正题啊
 *  对于一个数A,
 *  若是A的左边累计数非负,那么加上A能使得值不小于A,认为累计值对整体和是有贡献的;
 *  如果前几项累计值负数,则认为有害于总和,total记录当前值.
 *  此时,若和大于maxSum,则用maxSum记录下来
 */
package forOffer3;

public class maxTotalInArray {
    public static void main(String[] args) {
        int[] input = new int[]{6, -3, -2, 7, -15, 1, 2, 2};
        System.out.println(getMaxTotal(input));
    }

    public static int getMaxTotal(int[] array) {
        if(array == null || array.length == 0)
            return 0;
        int total = array[0];
        int maxTotal = array[0];
        for(int i = 1;i < array.length;i++) {

            // 当前的和大于0,也就是说在当前的情况下继续累加会比只累加之后的值大【等于0不干扰哦
            if(total >= 0)
                total += array[i];

            // 当前的和小于0,也就是说在当前的情况下继续累加会比只累加之后的值小,所以就从当前的值开始累加计算
            else
                total = array[i];

            // 如果此时的total大于maxTotal的值,就进行替代
            if(total > maxTotal)
                maxTotal = total;
        }

        return maxTotal;
    }
}
