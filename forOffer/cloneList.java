/**
 * 题目描述:
 *   输入一个复杂链表(每个节点中有节点值, 以及两个指针, 一个指向下一个节点, 另一个特殊指针指向任意一个节点),
 *   返回结果为复制后复杂链表的head.
 * (注意: 输出结果中请不要返回参数中的节点引用, 否则判题程序会直接返回空)
 *
 * 思路：
 * http://note.youdao.com/noteshare?id=c3b934e2c1a1766409787b5e25a308c7
 *
 * 运行性能：
 *   运行时间：30ms
 *   占用内存：9688k
 */
package forOffer2;

public class cloneList {
    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead == null)
            return null;

        // 1.复制结点中的值并修改next指针域
        RandomListNode pCurr = pHead;
        while(pCurr != null) {
            // 创建新结点并赋值
            RandomListNode node = new RandomListNode(pCurr.label);

            // 修改指向
            node.next = pCurr.next;
            pCurr.next = node;
            pCurr = pCurr.next.next;
        }

        // 2.复制random域
        pCurr = pHead;
        while(pCurr != null) {
            if(pCurr.random != null)
                pCurr.next.random = pCurr.random.next;
            pCurr = pCurr.next.next;
        }

        // 3.将链表进行拆分, 奇数位都是原来的结点, 偶数位都是新的结点
        pCurr = pHead;
        RandomListNode pHeadNew = pHead.next;
        RandomListNode pCurrNew = pHeadNew;

        while(pCurr != null) {
            pCurr.next = pCurr.next.next;
            if(pCurrNew.next != null)
                pCurrNew.next = pCurrNew.next.next;
            pCurr = pCurr.next;
            pCurrNew = pCurrNew.next;
        }

        return pHeadNew;

    }
}
