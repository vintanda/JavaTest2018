/**
 * @Date 2018/05/15
 * @Author LZD
 *
 * 题目描述：
 *   输入一颗二叉树和一个整数,打印出二叉树中结点值的和为输入整数的所有路径.
 *   路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径.
 * 思路：
 *   其实就是DFS遍历, 使用递归完成
 *   递归的结束条件是：一旦target满足并且当前结点是叶子结点
 *
 * 运行性能：
 *   运行时间：21ms
 *   占用内存：8924k
 */
package forOffer2;

import java.util.ArrayList;

public class findPathOfTree {

    private ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root == null)
            return lists;

        list.add(root.val);
        target -= root.val;

        if(target == 0 && root.left == null && root.right == null) {
            // 这里记得要new一个ArrayList啊啊啊啊否则是空的!
            lists.add(new ArrayList<>(list));
        }

        FindPath(root.left, target);
        FindPath(root.right, target);

        list.remove(list.size() - 1);

        return lists;
    }

}
