/**
 * @Date 2018/08/08
 * @Author LZD
 *
 * 题目描述：
 *  请实现一个函数, 用来判断一颗二叉树是不是对称的.
 *  注意, 如果一个二叉树同此二叉树的镜像是同样的, 定义其为对称的.
 *
 * 思路：
 *  一个对称的树, 左孩子和右孩子一定是值相同的,
 *  并且左孩子的左孩子的值和右孩子的右孩子的值相同,
 *  左孩子的右孩子的值和右孩子的左孩子的值相同.
 *  以此类推, 递归实现.
 *
 * 运行性能：
 *  运行时间：12ms
 *  占用内存：9296k
 */
package forOffer5;

public class JudgeIsSymmetrical {
    boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot == null)
            // 这是一颗空树, 之前我返回的是false, 但是牛客网评测认为空树应该返回true就改了..
            return true;
        return isSym(pRoot.left, pRoot.right);
    }

    private boolean isSym(TreeNode left, TreeNode right) {
        if(left == null && right == null)
            return true;
        else if(left != null && right != null)
            return (left.val == right.val && isSym(left.left, right.right) && isSym(left.right, right.left));
        return false;
    }
}
/*
boolean isSym = false;
        if(pRoot == null)
            return false;
        if(pRoot.left == null && pRoot.right == null)
            return true;
        StringBuilder pervious = new StringBuilder();
        StringBuilder after = new StringBuilder();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(pRoot);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node.left != null)
                queue.add(queue.peek().left);
            if(node.right != null)
                queue.add(queue.peek().right);

            // 取得原来的层次遍历结果
            pervious.append(node.val);

            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;

        }
        queue.add(pRoot);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node.left != null)
                queue.add(queue.peek().left);
            if(node.right != null)
                queue.add(queue.peek().right);
            after.append(node.val);
        }

        return pervious.toString().equals(after.toString());
 */
