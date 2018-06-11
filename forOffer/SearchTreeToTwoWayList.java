/**
 * @Date 2018/05/15
 * @Author LZD
 *
 * 题目描述：
 *   输入一棵二叉搜索树, 将该二叉搜索树转换成一个排序的双向链表.
 *   要求不能创建任何新的结点(new), 只能调整树中结点指针的指向.
 *
 * 思路：
 *   中序遍历这棵二叉搜索树, 并且定义一个指向前一个结点的指针.
 *
 * 运行性能：
 *   运行时间：19ms
 *   占用内存：8600k
 */
package forOffer2;

public class SearchTreeToTwoWayList {
    TreeNode pre = null;
    TreeNode realHead = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        ConvertSub(pRootOfTree);
        return realHead;
    }

    public void ConvertSub(TreeNode pRootOfTree) {
        if(pRootOfTree == null)
            return;

        // 找到当前为转成链表部分的最小的结点
        ConvertSub(pRootOfTree.left);
        if(realHead == null) {
            // 证明是第一次找到最小值即整棵树的最小值, 找到双向链表的最左端
            pre = pRootOfTree;
            realHead = pRootOfTree;
        }else {
            // 将前一个结点的right域指向当前这结点, 将当前这个结点的left域指向前一个结点
            pre.right = pRootOfTree;
            pRootOfTree.left = pre;
            pre = pRootOfTree;
        }

        // 找到当前结点的右孩子
        ConvertSub(pRootOfTree.right);

    }
}
