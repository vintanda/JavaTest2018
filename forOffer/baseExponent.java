/**
 * @Author LZD  @Date 2018/04/27
 * 题目描述:
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 解题思路：
 * 全面考察指数
 * 1)判断输入是否是非法的：底数为零
 *      由于base是double类型不能使用==,所以需要实现一个方法isEqual用来判断底数是否约等于0;
 * 2)取指数的绝对值进行计算
 * 3)计算时通过递归调用使时间复杂度降低,将a^b ---> a^b/2 * a^b/2（偶数）a^b ---> a^b/2 * a^b/2 * a（奇数）
 * 4)判断指数是正数还是负数：
 *      正数：result
 *      负数：1 / result
 *
 * 附上 牛客网 剑指Offer 一枚大牛的作品：
 * 链接：https://www.nowcoder.com/questionTerminal/1a834e5e3e1a4b7ba251417554e07c00   来源：牛客网
 * 1.全面考察指数的正负、底数是否为零等情况。
 * 2.写出指数的二进制表达，例如13表达为二进制1101。
 * 3.举例:10^1101 = 10^0001*10^0100*10^1000。
 * 4.通过&1和>>1来逐位读取1101，为1时将该位代表的乘数累乘到最终结果。
    public double Power(double base, int n) {
        double res = 1,curr = base;
        int exponent;
        if(n>0){
            exponent = n;
        }else if(n<0){
            if(base==0)
                throw new RuntimeException("分母不能为0"); 
            exponent = -n;
        }else{// n==0
            return 1;// 0的0次方
        }
        while(exponent!=0){
            if((exponent&1)==1)
                res*=curr;
            curr*=curr;// 翻倍
            exponent>>=1;// 右移一位
        }
        return n>=0?res:(1/res);       
    }
 */
package forOffer;

public class baseExponent {
    public static void main(String[] args) {
        // 看正负数的二进制
        System.out.println(Integer.toBinaryString(13));
        System.out.println(Integer.toBinaryString(-13));

        // 该题目的测试调用
        System.out.println(Power(2.0, 3));
    }
    static boolean InvalidInput = false;
    public static double Power(double base, int exponent) {
        if(isEqual(base, 0.0)) {
            // 非法输入
            InvalidInput = true;
            return 0.0;
        }
        int absExponent = exponent > 0 ? exponent : -exponent;
        double result = getPower(base, absExponent);
        if(exponent < 0)
            return 1/result;
        else
            return result;
    }

    // 判断底数是否为零
    public static boolean isEqual(double num1, double num2) {
        if((num1 - num2 > -0.000001) && (num1 - num2 < 0.000001))
            return true;
        else
            return false;
    }

    // 得到值
    public static double getPower(double base, int exponent) {
        if(exponent == 0)
            return 1.0;
        if(exponent == 1)
            return base;
        else {
            // 递归调用
            double result = getPower(base, exponent >> 1);
            result *= result;
            if((exponent & 1) == 1) {
                result *= base;
            }
            return result;
        }
    }
}
