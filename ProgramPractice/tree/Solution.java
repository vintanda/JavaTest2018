/**
 * @author LZD		2018/02/05
 */
/*
 * ��Դ��ţ����	����ָOffer����4��
 * ��Ŀ����:
 * ����ĳ��������ǰ���������������Ľ�������ؽ����ö�������
 * ���������ǰ���������������Ľ���ж������ظ������֡�
 * ��������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}��
 * ���ؽ������������ء�
 * 
 * ˼·��
 * �Ȼع�һ���������ֱ�����
 * ǰ��˫�׽ڵ� -> ���� -> �Һ���
 * �������� -> ˫�׽ڵ� -> �Һ���
 * �������� -> �Һ��� -> ˫�׽ڵ�
 * 
 * ǰ������ĵ�һ��������root����������ӣ��Ҳ����Һ���
 * ʹ�õݹ��˼�룬
 * �����ӽ����Ϊ�µ�˫�׽ڵ㣬�Ҹýڵ�����Һ���
 * ������������Ϊѭ���������б�����
 */
package tree;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root=reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }
    
    private TreeNode reConstructBinaryTree(int [] pre,int startPre,int endPre,
                                           int [] in,int startIn,int endIn) {
        if(startPre > endPre || startIn > endIn) {
            return null;
        }
        TreeNode root = new TreeNode(pre[startPre]);
        
        for(int i = startIn;i <= endIn;i++) {
            if(in[i] == pre[startPre]) {
                root.left = reConstructBinaryTree(pre, startPre+1, startPre+i-startIn,
                                                 in, startIn, i-1);
                root.right = reConstructBinaryTree(pre, i-startIn+startPre+1, endPre,
                                                  in, i+1, endIn);
            }
        }
        return root;
    }
    
    
	public static void main(String[] args) {
		int[] pre = new int[]{1,2,4,7,3,5,6,8};
		int[] in = new int[]{4,7,2,1,5,3,8,6};
		new Solution().reConstructBinaryTree(pre, in);
	}
}
