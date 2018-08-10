/**
 * @Date 2018/08/06
 * @Author LZD
 *
 * 题目描述：
 *  将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能,
 *  但是string不符合数字要求时返回0), 要求不能使用字符串转换整数的库函数.
 *  数值为0或者字符串不是一个合法的数值则返回0.
 *
 * 输入描述:
 *  输入一个字符串,包括数字字母符号,可以为空
 * 输出描述:
 *  如果是合法的数值表达则返回该数字，否则返回0
 *
 * 思路：
 *  字符串分割, 对每一位进行判断, 然后计算就ok
 *
 * 运行性能：
 *  运行时间：10ms
 *  占用内存：9552k
 */
package forOffer4;

public class StrParseInt {
    public static void main(String[] args) {
        System.out.println(new StrParseInt().StrToInt("+33445"));
        System.out.println(new StrParseInt().StrToInt("-33445"));
        System.out.println(new StrParseInt().StrToInt("+1a,45"));
        System.out.println(new StrParseInt().StrToInt("3445"));
    }
    public int StrToInt(String str) {
        if(str == null || str.length() == 0)
            return 0;
        char[] chars = str.toCharArray();
        boolean positive = true;
        if(chars[0] == '-')
            positive = false;
        int res = 0;
        for(int i = (chars[0] == '+' || chars[0] == '-' ? 1 : 0);i < chars.length;i++) {
            if(!(chars[i] >= '0' && chars[i] <= '9'))
                return 0;
            res = res * 10 + (chars[i] - '0');
        }
        return positive ? res : res * (-1);
    }
}
