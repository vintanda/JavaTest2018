/**
 * @Date 2018/05/28
 * @Author LZD
 * 题目描述：
 *   输入一个字符串,按字典序打印出该字符串中字符的所有排列.
 *   例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串
 *   abc,acb,bac,bca,cab和cba。
 * 输入描述:
 *   输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母.
 * 思路：
 *   对每一位和后面所有的位进行一次交换,个人认为是一个类似深度优先的想法
 *   一位一位进行递归,直到最后一位确定时将此排列方式得到的字符串加入到集合中
 *   【有道云：
 *   http://note.youdao.com/noteshare?id=d637b36e41b569c40a88ee9b7e0d93fc
 *
 * 算法性能：
 *   运行时间：211ms
 *   占用内存：11948k
 */
package forOffer2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class strDictPermutation {
    public static void main(String[] args) {
        System.out.println(Permutation("abc").toString());
    }

    private static ArrayList<String> Permutation(String str) {
        List<String> list = new ArrayList<>();
        if(str != null && str.length() > 0) {
            char[] cs = str.toCharArray();
            PermutationHelper(cs, 0, list);
            Collections.sort(list);
        }
        return (ArrayList<String>) list;
    }

    private static void PermutationHelper(char[] cs, int i, List<String> list) {
        // 已经找到了最后一位
        if(i == cs.length - 1) {
            String s = String.valueOf(cs);
            if(!list.contains(s))
                list.add(s);
        }else {
            // 没有找到最后一位,通过递归继续往后找
            for(int j = i;j < cs.length;j++) {
                // 对当前位和后面的每一位进行交换[因为for循环
                swap(cs, i, j);

                // 对下一位进行同样的操作
                PermutationHelper(cs, i + 1, list);

                // 换回来,为了另一种情况进行铺垫
                swap(cs, i, j);
            }
        }
    }

    private static void swap(char[] cs, int i, int j) {
        char tmp = cs[i];
        cs[i] = cs[j];
        cs[j] = tmp;
    }
}
