/**
 * @Date 2018/08/6
 * @Author LZD
 *
 * 题目描述：
 *  每年六一儿童节, 牛客都会准备一些小礼物去看望孤儿院的小朋友, 今年亦是如此.
 *  HF作为牛客的资深元老, 自然也准备了一些小游戏.
 *  其中, 有个游戏是这样的:
 *  首先, 让小朋友们围成一个大圈.
 *  然后, 他随机指定一个数m, 让编号为0的小朋友开始报数.
 *  每次喊到 m-1 的那个小朋友要出列唱首歌, 然后可以在礼品箱中任意的挑选礼物,
 *  并且不再回到圈中, 从他的下一个小朋友开始, 继续 0...m-1 报数....这样下去....
 *  直到剩下最后一个小朋友, 可以不用表演, 并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^).
 *  请你试着想下, 哪个小朋友会得到这份礼品呢?(注：小朋友的编号是从0到n-1)
 *
 * 思路：
 *  约瑟夫环形问题
 *  一开始看错题了, 以为是每次都从第一个小朋友开始, 然后发现是从出环的小朋友的下一个小朋友开始
 *  就是一个环形链表的问题
 *  (index + m - 1) % list.size() -> 重点
 *
 * 运行性能：
 *  运行时间：33ms
 *  占用内存：9924k
 */
package forOffer4;

import java.util.LinkedList;

public class LastRemaining {
    public static void main(String[] args) {
        System.out.println(new LastRemaining().LastRemaining_Solution(5,3));
    }
    public int LastRemaining_Solution(int n, int m) {
        if(n == 0)
            return -1;
        if(n == 1)
            return 0;
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0;i < n;i++)
            list.add(i);
        int index = 0;
        while(list.size() > 1) {
            index = (index + m - 1) % list.size();
            list.remove(index);
        }
        return list.get(0);
    }
}
