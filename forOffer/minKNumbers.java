/**
 * @Author LZD
 * @Date 2018/06/11
 *
 * 题目描述：
 *  输入n个整数,找出其中最小的K个数.例如输入4,5,1,6,2,7,3,8这8个数字,则最小的4个数字是1,2,3,4.
 *
 * 思路：
 *  思路有三种：
 *  1)基于堆排序算法,构建最小堆,时间复杂度为O(NlogK)
 *  2)如果用快速排序,时间复杂度为O(NlogN)；
 *  3)如果用冒泡排序,时间复杂度为O(n*k)
 *
 *  此处是使用了优先级队列,优先级队列的底层实现其实就是最小堆;
 *  我们使用优先级队列保存最小的k个数,并且通过CompareTo方法设置为最大堆,即第一个数是优先级队列中最大的数;
 *  遍历数组时,如果优先级队列中的数没有k个,则直接将数组中遍历到的数加入;
 *  如果优先级队列已经满了,则要对堆顶数和遍历到的数进行比较;
 *  如果比堆顶的数小,则将堆顶的数弹出并将遍历到的数添加到该优先级队列中.
 *
 * 性能分析：
 *  运行时间：34ms
 *  占用内存：9856k
 */
package forOffer2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class minKNumbers {
    public static void main(String[] args) {
        int[] input = new int[]{2, 1, 3, 6, 0, 5};
        System.out.println(getMinKNums(input, 4));
    }

    public static ArrayList<Integer> getMinKNums(int[] input, int k) {
        if(input == null)
            return null;

        // 创建一个ArrayList对象存放结果
        ArrayList<Integer> result = new ArrayList<>();
        if(input.length < k  || input.length == 0 || k == 0)
            return result;

        // 创建一个存放最小的k个数的优先级队列
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        // 向堆中添加数,得到最小的k个数
        for(int i = 0;i < input.length;i++) {
            // 当优先级队列未放满时,直接添加数组中的数
            if(minHeap.size() < k)
                minHeap.offer(input[i]);
            else {
                // 如果当前的堆顶大于遍历的数,则将堆顶弹出,并将新的数放入堆中
                if(minHeap.peek() > input[i]) {
                    minHeap.poll();
                    minHeap.offer(input[i]);
                }
            }
        }

        //
        for (Integer tmp : minHeap) {
            result.add(tmp);
        }

        return result;
    }
}
