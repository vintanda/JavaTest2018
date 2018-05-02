/**
 * @Author LZD
 * @Date 2018/05/01
 *
 * 题目描述：
 *  输入一个链表,反转链表后,输出链表的所有元素
 * 思路：
 *  设置一个pre指针指向当前结点的前一个结点,设置一个next指向当前的下一个结点,
 *  标记当前结点的下一个结点后将next域指向前一个结点
 */
package forOffer;

public class reversLinkList {
    public ListNode ReverseList(ListNode head) {
        if(head == null)
            return null;
        ListNode curr = head;
        ListNode pre = null;
        ListNode next;
        while(curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
