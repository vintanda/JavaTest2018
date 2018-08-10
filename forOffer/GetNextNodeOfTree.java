/**
 * @Date 2018/08/08
 * @Author LZD
 *
 * 题目描述：
 *  给定一个二叉树和其中的一个结点, 请找出中序遍历顺序的下一个结点并且返回.
 *  注意, 树中的结点不仅包含左右子结点, 同时包含指向父结点的指针.
 *
 * 思路：
 *  根据中序遍历的规则整理一下某个节点的下一个节点如何找：
 *  1.看是否有右孩子 -> 有 -> 返回右孩子的最左节点
 *                 -> 没有 -> 转2
 *  2.是否有父节点 -> 没有 -> 返回null(因为到跟节点了, 而且还没有右孩子就是最后一个了)
 *               -> 有 -> 转3
 *  3.该节点是父节点的左/右孩子 -> 左 -> 返回父节点
 *                          -> 右 -> 把当前节点的父节点作为当前节点回到2
 *
 * 运行性能：
 *  运行时间：16ms
 *  占用内存：9800k
 */
/*
public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
 */
package forOffer5;

public class GetNextNodeOfTree {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode == null)
            return null;

        // 如果有右孩子, 返回右孩子的最左节点
        if(pNode.right != null) {
            TreeLinkNode node = pNode.right;
            while(node.left != null) {
                node = node.left;
            }
            return node;
        }else {
            // 如果没有右孩子...
            TreeLinkNode tmpNode = pNode;
            while(true) {
                // 有没有父节点
                if (tmpNode.next == null) {
                    // 没有父节点
                    return null;
                } else {
                    // 有父节点
                    TreeLinkNode parent = tmpNode.next;
                    if (parent.left == tmpNode) {
                        // 当前节点是父节点的左孩子
                        return parent;
                    } else {
                        // 当前节点是父节点的右孩子, 以父节点作为新的节点去找它的父节点
                        tmpNode = parent;
                    }
                }
            }
        }

    }
}
