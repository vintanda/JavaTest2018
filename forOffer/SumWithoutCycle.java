/**
 * @Date 2018/08/06
 * @Author LZD
 *
 * 题目描述：
 *  求1+2+3+...+n, 要求不能使用乘除法/for/while/if-else/switch-case等关键字及条件判断语句(A?B:C).
 *
 * 思路：
 *  使用递归计算【本来在想能不能用fork/join计算, 然后想到那个需要选择分支判断
 *  使用短路, 传入的值不大于0作为递归终止条件, 之后的计算就不会再进行
 *
 * 运行性能：
 *  运行时间：14ms
 *  占用内存：9240k
 */
package forOffer4;

public class SumWithoutCycle {
    public int Sum_Solution(int n) {
        int sum = n;
        boolean ans = (sum > 0) && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }
}
