/**
 * @author LZD		2018/02/05
 */
/*
 * 来源：牛客网	《剑指Offer》第4题
 * 题目描述:
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建二叉树并返回。
 * 
 * 思路：
 * 先回顾一下树的三种遍历：
 * 前序：双亲节点 -> 左孩子 -> 右孩子
 * 中序：左孩子 -> 双亲节点 -> 右孩子
 * 后序：左孩子 -> 右孩子 -> 双亲节点
 * 
 * 前序遍历的第一个结点就是root，左侧是左孩子，右侧是右孩子
 * 使用递归的思想，
 * 将孩子结点作为新的双亲节点，找该节点的左右孩子
 * 以中序序列作为循环，将序列遍历完
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
