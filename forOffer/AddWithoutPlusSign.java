/**
 * @Date 2018/08/06
 * @Author LZD
 *
 * 题目描述：
 *  写一个函数, 求两个整数之和, 要求在函数体内不得使用+ - * /四则运算符号.
 *
 * 思路：
 *  位运算
 *  1.计算不带进位的加法 => ^
 *  2.计算哪些位需要进位 => &
 *  3.如果有需要的进位就将1和2的作为num1和num2到1中进行计算
 *
 * 运算性能：
 *  运行时间：16ms
 *  占用内存：9128k
 */
package forOffer4;

public class AddWithoutPlusSign {
    public static void main(String[] args) {
        System.out.println(new AddWithoutPlusSign().Add(5, 7));
    }
    public int Add(int num1, int num2) {
        while (num2 != 0) {
            // 不算进位的加法
            int tmp = num1 ^ num2;

            // 应该进的位
            num2 = (num1 & num2) << 1;

            // 此时的结果传给num1, 用于下次和应近的位进行运算
            num1 = tmp;
        }
        return num1;
    }
}
