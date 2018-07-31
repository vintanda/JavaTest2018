/**
 * @Author LZD
 * @Date 2018/06/14
 *
 * 题目描述：
 *  输入一个正整数数组,把数组里所有数字拼接起来排成一个数,打印能拼接出的所有数字中最小的一个.
 *  例如输入数组{3, 32, 321},则打印出这三个数字能排成的最小数字为321323.
 *
 * 思路：
 *  使用了Collections类中的sort方法,重写了Comparator接口,
 *  定义规则：
 *      String str1 = o1 + "" + o2;
 *      String str2 = o2 + "" + o1;
 *      return str1.compareTo(str2);
 *  比如o1 = 3222, o2 = 3 ==> str1 = 32223, str2 = 33222
 *  使用compareTo方法返回,将较小的String排在前面
 *  那么什么是排在前面?举几个栗子~~
 *      e.g. axin 排在 zdzd 前面 ---- 同位置上的字母不同;
 *           axin 排在 axxx 前面 ---- 同位置上的字母不同;
 *           axi 排在 axin 前面 ---- 同位置上字母相同,短的排在前面.
 *  ok,那么返回的在栗子中就是str1在str2前面,就达到了我们的目的
 *
 * 运行性能：
 *  运行时间：23ms
 *  占用内存：9624k
 */
package forOffer3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class printMinNumber {
    public static void main(String[] args) {
        int[] numbers = new int[]{3334,3,3333332};
        System.out.println(printMinNum(numbers));
    }

    public static String printMinNum(int [] numbers) {
        String str = "";
        ArrayList<Integer> nums = new ArrayList<>();
        for (int num : numbers) {
            nums.add(num);
        }

        Collections.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String str1 = o1 + "" + o2;
                String str2 = o2 + "" + o1;
                return str1.compareTo(str2);
            }
        });

        for (int num : nums) {
            str += num;
        }

        return str;
    }
}
