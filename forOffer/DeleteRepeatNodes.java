/**
 * @Date 2018/08/08
 * @Author LZD
 *
 * 题目描述：
 *  在一个排序的链表中, 存在重复的结点, 请删除该链表中重复的结点, 重复的结点不保留, 返回链表头指针.
 *  例如, 链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
 * 思路：
 *  去除所有重复的节点, 留下的都是值只出现了一次的节点
 *  需要注意的是头节点和尾节点是否出现越界问题...
 *  这bug改贼久...
 *  需要三个指针：
 *      pre用来标记上一个不同的节点(此处需要处理如果头节点就有重复, 则需要更换头节点的问题)
 *      p用来标记当前找的节点位置
 *      tmp临时标记p的前一个节点, 为找到不重复的节点
 *
 * 运行性能：
 *  运行时间：23ms
 *  占用内存：9456k
 */
package forOffer5;

public class DeleteRepeatNodes {
    public static void main(String[] args) {
        ListNode pHead = new ListNode(1);
        ListNode node1 = new ListNode(2);
        pHead.next = node1;
        ListNode node2 = new ListNode(3);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(5);
        node3.next = node4;
        System.out.println(new DeleteRepeatNodes().deleteDuplication(pHead));
    }
    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead == null || pHead.next == null)
            return pHead;

        ListNode pre = pHead, p = pHead;
        while(p != null) {
            // 如果当前节点和下一个节点中的值相等, p找下一个值不同的节点
            if(p.next != null && p.val == p.next.val) {
                // 临时节点用来标记p的前一个节点
                ListNode tmp = p;

                // 还没有找到值不同的节点
                while(p != null && tmp.val == p.val) {
                    tmp = p;
                    p = p.next;
                }

                // 如果pre和tmp的值相同 -> pre指向的是pHead, 更换头节点到p, pre也指向p
                if(pre.val == tmp.val) {
                    pHead = p;
                    pre = p;
                }else {
                    // 否则就是中间的节点有重复, pre的next指向p
                    pre.next = p;
                }

                // 释放p之前删掉的节点
                tmp.next = null;
            } else {
                pre = p;
                p = p.next;
            }
        }
        return pHead;
    }
}
