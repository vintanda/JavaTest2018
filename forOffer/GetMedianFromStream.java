/**
 * @Date 2018/08/10
 * @Author LZD
 *
 * 题目描述：
 *  如何得到一个数据流中的中位数?
 *  如果从数据流中读出奇数个数值, 那么中位数就是所有数值排序之后位于中间的数值.
 *  如果从数据流中读出偶数个数值, 那么中位数就是所有数值排序之后中间两个数的平均值.
 *  我们使用Insert()方法读取数据流, 使用GetMedian()方法获取当前读取数据的中位数.
 *
 * 思路：
 *  因为数据流是一个一个数字进行插入的, 如果使用排序的话每一次都需要一次排序(N*logN)
 *  使用两个优先级队列对数字进行排序,
 *  创建一个大顶堆存放小的数(第一个就是小的里面最大的)
 *  和一个小顶堆存放大的数(第一个就是大的里面最小的)
 *  再通过奇偶控制两个队列中的数的个数差不超过1, 从而保证中位数是某个队列poll的结果或两个队列poll和的一半
 *
 * 运行性能：
 *  运行时间：131ms
 *  占用内存：15312k
 */
package forOffer5;

import java.util.PriorityQueue;

public class GetMedianFromStream {
    public static void main(String[] args) {
        GetMedianFromStream test = new GetMedianFromStream();
        test.Insert(5);
        test.Insert(2);
        test.Insert(3);
        test.Insert(4);
        test.Insert(1);
        test.Insert(6);
        test.Insert(7);
        test.Insert(0);
        test.Insert(8);
        System.out.println(test.GetMedian());
    }
    // 小顶堆 --- 存放较大的数
    // (poll()得到的数是小顶堆中最小的数, 就是中位数或用来求中位数的两个数的一个数)
    // 先将数放入大顶堆中, 然后将大顶堆中最大的数(大顶堆.poll())放入小顶堆中
    private PriorityQueue<Integer> left = new PriorityQueue<>();
    // 大顶堆 --- 存放较小的数
    // (poll()得到的数是大顶堆中最大的数, 就是中位数或用来求中位数的两个数的一个数)
    // 先将数放入小顶堆中, 然后将小顶堆中最小的数(小顶堆.poll())放入大顶堆中
    private PriorityQueue<Integer> right = new PriorityQueue<>((o1, o2) -> o2 - o1);

    int count = 0;

    // 插入数字
    public void Insert(Integer num) {
        // 奇偶只是为了保证两个队列的差值不超过1, 以及大小顶堆依次交替放入值
        if(++count % 2 == 0) {
            right.add(num);
            left.add(right.poll());
        }else {
            left.add(num);
            right.add(left.poll());
        }
    }

    // 获取中位数
    public Double GetMedian() {
        if(count % 2 == 0) {
            // 偶数个数字
            return ((double)left.peek() + (double)right.peek()) / 2.0;
        }else {
            // 奇数个数字, 奇数个时放入的是哪个队列中, 哪个队列中的数就较多, 其poll()会得到中位数
            return (double)right.peek();
        }
    }

}
