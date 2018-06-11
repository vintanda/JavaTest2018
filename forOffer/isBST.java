/**
 * @Date 2018/05/11
 * @Author LZD
 * 题目描述：
 *   输入一个整数数组, 判断该数组是不是某二叉搜索树的后序遍历的结果.
 *   如果是则输出Yes, 否则输出No.
 *   假设输入的数组的任意两个数字都互不相同.
 * 思路：
 *   后序遍历二叉排序树的结果的规则是：
 *   对于一个序列S,最后一个元素是x(也就是根),如果去掉最后一个元素的序列为T.
 *   那么T可以分成两段:
 *      前一段(左子树)小于x,
 *      后一段(右子树)大于x,且这两段子树都是合法的后序序列.
 */
package forOffer2;

public class isBST {

    public static void main(String[] args) {
        int[] sequence = new int[] {2,3,7,9,8,5};
        boolean result = VerifySquenceOfBST(sequence);
        if(result)
            System.out.println("Yes");
        else
            System.out.println("false");
    }

    public static boolean VerifySquenceOfBST(int [] sequence) {
        // 使用断言抛出异常
        assert sequence.length != 0;

        // 输入数组长度为1,直接返回true
        if(sequence.length == 1)
            return true;

        // 取得数组最后位置的数为root的值
        int root = sequence[sequence.length - 1];

        // 调用judge方法
        return judge(sequence, root, 0, sequence.length - 1);
    }

    static boolean judge(int[] sequence, int root, int left, int right) {
        // 长度为1直接返回
        if(right - left < 1)
            return true;

        // 记录新的root位置
        int index = 0;

        // 遍历数组
        for(int i = right - 1;i >= 0;i--) {
            // 当前这个数比root的值小
            if(sequence[i] < root) {
                // 找到了第一个比root小的值, 记录它的下标
                if(index == 0) {
                    index = i;
                }
            }

            // 当前这个数比root的值大并且在最先找到的比root小的数的左边, 直接返回false
            if(index != 0 && sequence[i] > root)
                return false;
        }

        return judge(sequence, sequence[index], left, index)
            && judge(sequence, sequence[right - 1], index + 1, right - 1);
    }
}
