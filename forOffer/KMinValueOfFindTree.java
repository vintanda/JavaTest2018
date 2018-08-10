/**
 * @Date 2018/08/10
 * @Author LZD
 *
 * 题目描述：
 *  给定一棵二叉搜索树, 请找出其中的第k小的结点.
 *  例如, (5, 3, 7, 2, 4, 6, 8)中, 按结点数值大小顺序第三小结点的值为4.
 *
 * 思路：
 *  非递归的中序遍历, 设置一个计数器记录是第几个值,
 *  因为是查找树, 左子树的任意一个值一定 < 右子树的任意一个值
 *  使用中序遍历一次, 结果就是从小到大的啦~
 *
 * 运行性能：
 *  运行时间：27ms
 *  占用内存：9692k
 */
package forOffer5;

import java.util.Stack;

public class KMinValueOfFindTree {
    TreeNode KthNode(TreeNode pRoot, int k) {
        if(pRoot == null || k <= 0)
            return null;
        TreeNode node = pRoot;
        int count = 0;
        Stack<TreeNode> stack = new Stack<>();
        do{
            if(node != null) {
                stack.push(node);
                node = node.left;
            }else {
                node = stack.pop();
                count++;
                if(k == count)
                    return node;
                node = node.right;
            }
        }while(!stack.isEmpty() || node != null);
        return null;
    }
}
