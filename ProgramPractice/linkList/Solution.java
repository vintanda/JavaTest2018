/**
 * @author LZD		2018/02/01
 */
/*
 * ��Ŀ������
 * ����һ��������β��ͷ��ӡ����ÿ���ڵ��ֵ��
 */
package linkList;

import java.util.ArrayList;
public class Solution {
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
    	//����һ���洢��������Ľ��ֵ��ArrayList�����δ�����ǵ�һ������ĳ�����
        ArrayList<Integer> reverseList = new ArrayList<>();
        
        /*
         * ����ArrayList��ÿ����ӵ��±�Ϊ0��λ����
         * API��
         * public void add(int index,E element)
         * �ڴ��б��е�ָ��λ�ò���ָ����Ԫ�ء� 
         * ����ǰλ�ڸ�λ�õ�Ԫ�أ�����У����κκ���Ԫ�أ������������һ�����ƶ��� 
         */
        //ֱ�����������������
        while(listNode!=null) {
            reverseList.add(0, listNode.val);
            //ȡ��һ�����
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
