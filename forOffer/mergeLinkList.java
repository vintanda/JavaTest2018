/**
 * @Author LZD
 * @Date 2018/05/02
 *
 * 题目描述：
 *  输入两个单调递增的链表,输出两个链表合成后的链表,当然我们需要合成后的链表满足单调不减规则
 * 思路：
 *  不开辟新空间进行归并排序,改变next域的指向
 */
package forOffer;

public class mergeLinkList {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;
        ListNode mergeHead = null;
        ListNode curr = null;
        while((list1 != null) && (list2 != null)) {
            if(list1.val <= list2.val) {
                if(mergeHead == null) {
                    mergeHead = curr = list1;
                }else {
                    curr.next = list1;
                    curr = curr.next;
                }
                list1 = list1.next;
            }else {
                if(mergeHead == null) {
                    mergeHead = curr = list2;
                }else {
                    curr.next = list2;
                    curr = curr.next;
                }
                list2 = list2.next;
            }
        }
        if(list1 == null)
            curr.next = list2;
        if(list2 == null)
            curr.next = list1;
        return mergeHead;
    }
}
