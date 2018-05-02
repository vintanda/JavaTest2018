/**
 * @Author LZD
 * @Date 2018/05/01
 *
 * 题目描述：
 *  输入一个链表,输出该链表中倒数第k个结点
 * 思路：
 *  快慢指针,pre指针先找k-1个位置,然后pre和last一起找,直到pre指针的next为空,last就指向倒数第K个位置
 * 运行结果性能：
 *  运行时间：15ms
 *  占用内存：9688k
 */
package forOffer;

public class findLastKIndexOfLinkList {
    // 只含功能代码
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null || k <= 0)
            return null;
        ListNode pre = head;
        ListNode last = head;
        for(int i = 0;i < k - 1;i++) {
            if(pre.next != null)
                pre = pre.next;
            else
                return null;
        }
        while(pre.next != null) {
            pre = pre.next;
            last = last.next;
        }
        return last;
    }
}