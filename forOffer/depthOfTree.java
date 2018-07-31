/**
 * 题目描述：
 *  输入一棵二叉树,求该树的深度.
 *  从根结点到叶结点依次经过的结点(含根 叶结点)形成树的一条路径,最长路径的长度为树的深度.
 *
 * 思路：
 *  层次遍历,每遍历一层,深度+1,使用队列存储结点
 *
 * 运行性能：
 *  运行时间：18ms
 *  占用内存：9160k
 */
package forOffer3;

import java.util.LinkedList;
import java.util.Queue;

public class depthOfTree {
    public int TreeDepth(TreeNode root) {
        if(root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 0;
        queue.add(root);
        TreeNode node;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0;i < size;i++) {
                node = queue.poll();
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            depth++;
        }
        return depth;
    }
}
