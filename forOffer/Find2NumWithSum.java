/**
 * @Date 2018/08/04
 * @Author LZD
 *
 * 题目描述：【左旋转字符串】
 *  输入一个递增排序的数组和一个数字S, 在数组中查找两个数, 使得他们的和正好是S,
 *  如果有多对数字的和等于S, 输出两个数的乘积最小的.
 *  对应每个测试案例, 输出两个数, 小的先输出.
 *
 * 思路：
 *  CVTE春招笔试 + 一面的题啊...
 *  快慢指针, low指向最小的, high指向最大的, 指针指向的两个数之和与sum相比,
 *  比sum小low++, 比sum大high--, 直到low和high的和与sum相等.
 *  关于输出两个乘积最小的...高中学数学的时候就知道吧...
 *  举个例子, 4 + 6 = 10, 2 + 8 = 10
 *  4 * 6 = 24, 2 * 8 = 16
 *  显而易见, 两边的乘积最小
 *
 * 运行性能：
 *  算法时间复杂度：O(n)
 *  运行时间：13ms
 *  占用内存：9560k
 */
package forOffer4;

import java.util.ArrayList;

public class Find2NumWithSum {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 5, 6, 9, 10};
        System.out.println(FindNumbersWithSum(nums, 8));
    }
    private static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if(array == null || array.length == 0)
            return list;

        int lowIndex = 0;
        int highIndex = array.length - 1;
        while(lowIndex < highIndex) {
            int tmp = array[lowIndex] + array[highIndex];
            if(tmp < sum)
                lowIndex++;
            else if(tmp > sum)
                highIndex--;
            else {
                list.add(array[lowIndex]);
                list.add(array[highIndex]);
                break;
            }
        }
        return list;
    }
}
