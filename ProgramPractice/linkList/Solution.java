/**
 * @author LZD		2018/02/01
 */
/*
 * 题目描述：
 * 输入一个链表，从尾到头打印链表每个节点的值。
 */
package linkList;

import java.util.ArrayList;
public class Solution {
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
    	//创建一个存储输入链表的结点值的ArrayList，传参传入的是第一个或者某个结点
        ArrayList<Integer> reverseList = new ArrayList<>();
        
        /*
         * 遍历ArrayList，每次添加到下标为0的位置上
         * API：
         * public void add(int index,E element)
         * 在此列表中的指定位置插入指定的元素。 
         * 将当前位于该位置的元素（如果有）和任何后续元素（向其索引添加一个）移动。 
         */
        //直到给的链表遍历结束
        while(listNode!=null) {
            reverseList.add(0, listNode.val);
            //取下一个结点
            listNode = listNode.next;
        }
        
        return reverseList;
    }
    
    public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		ArrayList<Integer> list = printListFromTailToHead(node1);
		for(int val : list) {
			System.out.println(val);
		}
	}
}
