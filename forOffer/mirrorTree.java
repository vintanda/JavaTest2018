/**
 * @Author LZD
 * @Date 2018/05/02
 *
 * 题目描述：
 *  操作给定的二叉树,将其变换为源二叉树的镜像
 * 思路：
 *  进行递归操作,一开始想的是交换值,题中给出的例子是个完全二叉树,太过理想化了...
 *  之后考虑到二叉树的孩子结点可能为空,在变为镜像的时候需要将其递归至叶子结点,
 *  进行结点的交换而不是值的交换
 */
package forOffer;

public class mirrorTree {
    public void Mirror(TreeNode root) {
        if(root == null)
            return;
        if(root.left == null && root.right == null)
            return;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        if(root.left != null)
            Mirror(root.left);
        if(root.right != null)
            Mirror(root.right);
    }
}
