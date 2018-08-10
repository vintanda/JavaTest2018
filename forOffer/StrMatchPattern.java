/**
 * @Date 2018/08/06
 * @Author LZD
 *
 * 题目描述：
 *  请实现一个函数用来匹配包括'.'和'*'的正则表达式.
 *  模式中的字符'.'表示任意一个字符, 而'*'表示它前面的字符可以出现任意次(包含0次).
 *  在本题中, 匹配是指字符串的所有字符匹配整个模式.
 *  例如, 字符串"aaa"与模式"a.a"和"ab*ac*a"匹配, 但是与"aa.a"和"ab*a"均不匹配.
 *
 * 思路：
 *  先看'*', 再看是否匹配
 *  前提：当pattern遍历完, return取决于str是否遍历完, str恰好遍历完才返回true, 再接下来讨论
 *      1.若当前字符存在下一个字符，看下一个字符是否是 '*'，如果是，有2种情况
 *      1)当前匹配
 *        - match(str,i + 1,pattern,j)  //跳过str
 *        - match(str,i,pattern,j + 2)  //跳过pattern
 *        - match(str,i + 1,pattern,j + 2)  //这一种可以省略，相当于 1.1 + 1.2
 *      2)当前不匹配
 *      match(str,i,pattern,j + 2)  //跳过pattern
 * 2.下一个不是'*'
 *     当前匹配 return match(str,i + 1,pattern,j + 1)
 *
 * 运行性能：
 *  运行时间：17ms
 *  占用内存：9424k
 */
package forOffer4;

public class StrMatchPattern {
    public static void main(String[] args) {
        String str = "aaa";
        String pattern1 = "a.aa";
        System.out.println(new StrMatchPattern().match(str.toCharArray(), pattern1.toCharArray()));
    }
    public boolean match(char[] str, char[] pattern) {
        if(str == null || pattern == null)
            return false;
        if(str.length == 0 && pattern.length == 0)
            return true;
        int strIndex = 0, patternIndex = 0;
        return match(str, strIndex, pattern, patternIndex);
    }

    private boolean match(char[] str, int strIndex, char[] pattern, int patternIndex) {
        if(patternIndex == pattern.length)//pattern遍历完了
            return str.length == strIndex;//如果str也完了，返回true，不然false
        // 注意数组越界问题, 一下情况都保证数组不越界 并且下一个是'*'
        if(patternIndex < pattern.length - 1 && pattern[patternIndex + 1] == '*') {
            // 没有越界
            if(str.length != strIndex &&
                 // 字符匹配
                (str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.'))
                return match(str,strIndex,pattern,patternIndex + 2) || match(str,strIndex + 1,pattern,patternIndex);
            else
             //当前不匹配
             return match(str,strIndex,pattern,patternIndex + 2);
        }
        //下一个不是'*', 当前匹配
        if(str.length != strIndex && (str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.'))
            return match(str,strIndex + 1,pattern,patternIndex + 1);
        return false;
    }
}