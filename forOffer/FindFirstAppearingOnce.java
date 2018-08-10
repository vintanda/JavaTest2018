/**
 * @Date 2018/08/06
 * @Author LZD
 *
 * 题目描述：
 *  请实现一个函数用来找出字符流中第一个只出现一次的字符.
 *  例如, 当从字符流中只读出前两个字符"go"时, 第一个只出现一次的字符是"g".
 *       当从该字符流中读出前六个字符“google"时, 第一个只出现一次的字符是"l".
 * 输出描述:
 *  如果当前字符流没有存在出现一次的字符, 返回 '#'.
 *
 * 思路：
 *  大体思想相同, 两种实现方式：
 *  1.数组实现：
 *      创建一个大小可以保证每个字符都有一个空间的数组, 可见字符一共只有128个, 所以128个就够用
 *      在插入时, 使用StringBuilder对输入的字符进行拼接得到输入的字符串str
 *      每一个字符的值对应一个下标
 *      数组中的值先全部初始化为0, 每次找到对应的位置就对该位置上的值++
 *      最后遍历str.toCharArray(), 再以相同的方式找到该字符所对应的位置, 若值为1就直接返回
 *      循环结束没有找到就返回 '#'
 *      【结果最后有一个数组越界问题, 80%用例, 实在找不出来改用集合的方式
 *  2.集合实现：
 *      使用一个有序的集合LinkedHashMap
 *      Entry中存储的是字符串以及出现次数
 *      通过containsKey函数判断是否已经有该字符, 如果有就将value值++
 *      最后遍历这个map, 一旦找到一个value为1的entry就将这个key返回
 *      循环结束没有找到就返回 '#'
 *
 * 运行性能：【是集合实现的性能】
 *  运行时间：15ms
 *  占用内存：9564k
 */
package forOffer4;

import java.util.LinkedHashMap;
import java.util.Map;

public class FindFirstAppearingOnce {
    public static void main(String[] args) {
        System.out.println('a' - '0');
        System.out.println('c' - '0');
        System.out.println('A' - '0');
    }

    LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
    public void Insert(char ch) {
        if(map.containsKey(ch))
            map.put(ch, (map.get(ch) + 1));
        else
            map.put(ch, 1);
    }

    public char FirstAppearingOnce() {
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1)
                return entry.getKey();
        }
        return '#';
    }




//    StringBuilder builder = new StringBuilder();
//    int[] appearceTime = new int[256];
//
//    public FindFirstAppearingOnce() {
//        for(int i = 0;i < 256;i++)
//            appearceTime[i] = 0;
//    }
//
//    //Insert one char from stringstream
//    public void Insert(char ch) {
//        builder.append(ch);
//        int index = ch-'0';
//        appearceTime[index]++;
//    }
//    //return the first appearence once char in current stringstream
//    public char FirstAppearingOnce() {
//        char[] chars = builder.toString().toCharArray();
//        for(char ch : chars) {
//            int index = ch-'0';
//            if(appearceTime[index] == 1)
//                return ch;
//        }
//        return '#';
//    }
}
