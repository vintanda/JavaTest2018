/**
 * @Date 2018/08/08
 * @Author LZD
 *
 * 题目描述：
 *  请实现一个函数按照之字形打印二叉树,
 *  即第一行按照从左到右的顺序打印,
 *  第二层按照从右至左的顺序打印,
 *  第三行按照从左到右的顺序打印,
 *  其他行以此类推.
 *
 * 思路：
 *  1.之字形：设置一个boolean型变量控制是奇数行还是偶数行(或者设置一个统计地几行的变量)
 *  2.LinkedList底层是一个双向链表, 所以可以采用
 *
 * 运行性能：
 *  运行时间：19ms
 *  占用内存：9696k
 */
package forOffer5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class PrintTreeByRow {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> print = new ArrayList<>();
        if(pRoot == null)
            return print;

        // 临时存储一行的数据
        ArrayList<Integer> list = new ArrayList<>();

        // 层次遍历
        LinkedList<TreeNode> queue = new LinkedList<>();

        // 添加层分隔符
        queue.addLast(null);

        // 将root节点放入链表中存储
        queue.addLast(pRoot);

        // 判断应该从左往右输入还是从右往左输出
        boolean leftOrRight = true;

        // 因为第一个元素是分隔符, 所以如果只剩下一个元素就是那个分隔符
        while(queue.size() != 1) {
            TreeNode node = queue.removeFirst();

            // 遇到分隔符
            if(node == null) {
                Iterator<TreeNode> it = null;
                if(leftOrRight) {
                    it = queue.iterator();
                }else {
                    it = queue.descendingIterator();
                }
                leftOrRight = !leftOrRight;

                while (it.hasNext()) {
                    TreeNode temp = it.next();
                    list.add(temp.val);
                }

                // 将这一行的数据加入到print中, 并清空保存
                print.add(new ArrayList<>(list));
                list.clear();
                queue.addLast(null);    // 添加分隔符
                continue;
            }
            // 添加孩子节点
            if(node.left != null)
                queue.addLast(node.left);
            if(node.right != null)
                queue.add(node.right);
        }
        return print;
    }
}
