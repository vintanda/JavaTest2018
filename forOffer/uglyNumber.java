/**
 * @Date 2018/07/02
 * @Author LZD
 *
 * 题目描述：
 *  把只包含因子2/3/5的数称作丑数(Ugly Number)
 *  例如6和8都是丑数,但14不是,因为它包含因子7,习惯上我们把1当做是第一个丑数
 *  求按从小到大的顺序的第N个丑数
 *
 * 思路：
 *  动态规划思想,每次寻找最小数时都将因子(2/3/5)和未相乘过的最小的丑数作相乘操作后得到的三个数进行比较
 *  得到的最小的数就是当前情况下最小的丑数
 *
 * 性能：
 *  运行时间：19ms
 *  占用内存：9296k
 */
package forOffer3;

public class uglyNumber {
    public static void main(String[] args) {
        System.out.println(getUglyNumber(10));
    }

    public static int getUglyNumber(int N) {
        if(N <= 6)
            return N;

        // 使用2/3/5相乘的最小的数的下标
        int i2 = 0, i3 = 0, i5 = 0;

        // 存放丑数,最多有N个,返回是返回下标为N-1的数
        int[] dp = new int[N];

        // 1是第一个丑数
        dp[0] = 1;

        // 得到第i个丑数
        for(int i = 1;i < N;i++) {
            int next2 = dp[i2] * 2;
            int next3 = dp[i3] * 3;
            int next5 = dp[i5] * 5;

            // 确定第i个丑数
            dp[i] = Math.min(next2, Math.min(next3, next5));

            // 对下标志进行增加,不能使用else if,这样会导致数字重复
            if(dp[i] == next2)
                i2++;
            if(dp[i] == next3)
                i3++;
            if(dp[i] == next5)
                i5++;
        }

        // 返回第N个丑数
        return dp[N-1];
    }
}
