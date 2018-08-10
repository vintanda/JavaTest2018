/**
 * @Date 2018/08/09
 * @Author LZD
 *
 * 题目描述：
 *  给定一个数组和滑动窗口的大小, 找出所有滑动窗口里数值的最大值.
 *  例如, 如果输入数组{2,3,4,2,6,2,5,1} 及滑动窗口的大小3,
 *  那么一共存在6个滑动窗口, 他们的最大值分别为{4,4,6,6,6,5};
 *  针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 *    {[2,3,4],2,6,2,5,1}, {2,[3,4,2],6,2,5,1}, {2,3,[4,2,6],2,5,1},
 *    {2,3,4,[2,6,2],5,1}, {2,3,4,2,[6,2,5],1}, {2,3,4,2,6,[2,5,1]}.
 *
 * 思路：
 *  取部分最小值, num的长度为n, 滑动窗口大小为size, 一共有 (n-size+1) 个num数组的滑动窗口
 *  使用PriorityQueue存储当前划动窗口中的值, 创建队列的时候指定比较方式
 *  每次向右滑动一个位置, 添加一个num数组的值, 得到最大值放入最大值的list中(是peek不是poll)
 *  并每次弹出滑动窗口滑过的那个值(这是poll)
 *
 * 运行性能：
 *  运行时间：130ms
 *  占用内存：14184k
 */
package forOffer5;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MaxInWindows {
    public static void main(String[] args) {
        int[] num = new int[]{2, 3, 4, 2, 6, 2, 5, 1};
        int size = 3;
        System.out.println(new MaxInWindows().maxInWindows(num, size));
    }
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> ret = new ArrayList<>();
        if(num == null)
            return ret;
        if(num.length == 0 || num.length < size || size <= 0)
            return ret;
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for(int i = 0;i < size;i++)
            heap.add(num[i]);
        ret.add(heap.peek());
        for(int i = 0;i < num.length - size;i++) {
            heap.remove(num[i]);
            heap.add(num[size + i]);
            ret.add(heap.peek());
        }
        return ret;
    }
}
