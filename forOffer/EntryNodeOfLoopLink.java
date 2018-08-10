/**
 * @Date 2018/08/08
 * @Author LZD
 *
 * 题目描述：
 *  给一个链表, 若其中包含环, 请找出该链表的环的入口结点, 否则, 输出null.
 *
 * 思路：
 *  利用Hash族集合类
 *
 * 运行性能：
 *  运行时间：22ms
 *  占用内存：9436k
 */
package forOffer5;

import java.util.HashSet;

public class EntryNodeOfLoopLink {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if(pHead == null)
            return null;
        if(pHead.next == null)
            return null;
        ListNode node = pHead;
        HashSet<ListNode> nodes = new HashSet<>();
        boolean hasLoop = false;
        while(!hasLoop) {
            if(!nodes.add(node))
                hasLoop = true;
            else
                node = node.next;
        }
        return hasLoop ? node : null;
    }
}
