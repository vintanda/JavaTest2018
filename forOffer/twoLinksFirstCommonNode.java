/**
 * @Date 2018/07/24
 * @Author LZD
 *
 * 题目描述：
 *  输入两个链表，找出它们的第一个公共结点。
 *
 * 思路：
 *  【具体参见阿鑫的博客：https://blog.csdn.net/fengxinlinux/article/details/78885764】
 *  同时遍历两个链表到尾部,同时记录两个链表的长度.若两个链表最后的一个节点相同,则两个链表相交.
 *  有两个链表的长度后,我们就可以知道哪个链表长,设较长的链表长度为len1,短的链表长度为len2.
 *  则先让较长的链表向后移动(len1-len2)个长度.
 *  然后开始从当前位置同时遍历两个链表,当遍历到的链表的节点相同时,则这个节点就是第一个相交的节点.
 *
 * 运行性能：
 *  时间复杂度：O(min(len1,len2))
 *  运行时间：29ms
 *  占用内存：10112k
 *
 */
package forOffer3;

public class twoLinksFirstCommonNode {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        int len1 = 0;
        int len2 = 0;

        // 统计两个链表的长度
        while(p1 != null) {
            len1++;
            p1 = p1.next;
        }
        while(p2 != null) {
            len2++;
            p2 = p2.next;
        }

        // 统计后重置
        p1 = pHead1;
        p2 = pHead2;

        // 移动指针,若link1较长,将p1标记在第 (len2 - len1) 个结点上;反之,移动p2
        if(len1 > len2) {
            int sub = len1 - len2;
            while(sub-- != 0)
                p1 = p1.next;
        }else {
            int sub = len2 - len1;
            while(sub-- != 0)
                p2 = p2.next;
        }

        while(p1 != null) {
            if(p1.val == p2.val)
                return p1;
            p1 = p1.next;
            p2 = p2.next;
        }

        return null;
    }
}
