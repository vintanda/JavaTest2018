/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
package forOffer2;

import java.util.ArrayList;

public class treeHierarchicaTraversal {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<TreeNode> queue = new ArrayList<>();
        if(root == null)
            return list;
        queue.add(root);
        while(queue.size() != 0) {
            TreeNode node = queue.remove(0);
            if(node.left != null)
                queue.add(node.left);
            if(node.right != null)
                queue.add(node.right);
            list.add(node.val);
        }
        return list;
    }
}
