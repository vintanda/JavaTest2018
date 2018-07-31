/**
 * @Date 2018/07/25
 * @Author LZD
 *
 * 题目描述：
 *  输入一棵二叉树,判断该二叉树是否是平衡二叉树.
 *
 * 思路：
 *  所谓平衡二叉树,要满足以下两个条件：
 *    1)左右子树的深度差不大于1
 *    2)每个结点的左右子树都是平衡二叉树
 *  总之它就是一个高度平衡的二叉树,需要注意的是,没有大小关系
 *
 * 运行性能：
 *  运行时间：17ms
 *  占用内存：9332k
 */
package forOffer3;

public class isBalancedTree {
    private boolean isBalanced = true;
    public boolean IsBalanced_Solution(TreeNode root) {
        treeDepth(root);
        return isBalanced;
    }

    // 统计树的深度
    private int treeDepth(TreeNode root) {
        if(root == null || !isBalanced)
            return 0;

        // 递归调用
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);

        // 如果左右子树深度 >1,则不是平衡二叉树
        if(Math.abs(left - right) > 1)
            isBalanced = false;
        return 1 + Math.max(left, right);
    }
}
