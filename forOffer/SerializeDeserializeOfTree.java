/**
 * @Date 2018/08/10
 * @Author LZD
 *
 * 题目描述：
 *  请实现两个函数, 分别用来序列化和反序列化二叉树.
 *
 * 思路：
 *  序列化的时候采用任意一种遍历方式, 若节点为空, 使用特殊字符进行存储(习惯上使用'#')
 *  在每个节点的值后面都加上一个分隔字符(使用'!'/','之类的都可以啦)
 *  每遍历一个节点就将这个节点的值记录下来, 一般定义一个StringBuilder进行存储
 *
 *  反序列化的时候, 注意用和序列化相同的遍历方式对存储结果的String进行分析
 *  将每个节点的值得到, 如果是遇到'#'这种表示空的字符, 返回null
 *  返回的时候返回一个节点(对该节点的值和左右孩子都进行了初始化)
 *  这个节点返回给其父节点的左右孩子
 *
 * 运行性能：
 *  运行时间：40ms
 *  用内存：9736k
 */
package forOffer5;

public class SerializeDeserializeOfTree {
    int index = -1;
    String Serialize(TreeNode root) {
        StringBuilder resBuilder = new StringBuilder();
        if(root == null)
            return resBuilder.append("#!").toString();

        resBuilder.append(root.val + "!");
        resBuilder.append(Serialize(root.left));
        resBuilder.append(Serialize(root.right));

        return resBuilder.toString();
    }

    TreeNode Deserialize(String str) {
        index++;
        if(str.length() <= index) {
            return null;
        }
        String[] strs = str.split("!");
        TreeNode node = null;
        if(!"#".equals(strs[index])) {
            node = new TreeNode(Integer.valueOf(strs[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }

}
