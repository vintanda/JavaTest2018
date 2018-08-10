/**
 * @Date 2018/08/09
 * @Author LZD
 *
 * 题目描述：
 *  请设计一个函数, 用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径.
 *  路径可以从矩阵中的任意一个格子开始, 每一步可以在矩阵中向左, 向右, 向上, 向下移动一个格子.
 *  如果一条路径经过了矩阵中的某一个格子, 则之后不能再次进入这个格子.
 *  例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中
 *  包含一条字符串"bcced"的路径, 但是矩阵中不包含"abcb"路径,
 *  因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后, 路径不能再次进入该格子.
 *
 * 思路：
 *  用一个保存每个位置状态的数组flag, k用来标记到哪个字符,
 *  向四个方向递归比对下一个字符
 *
 * 运行性能：
 *  运行时间：13ms
 *  占用内存：9416k
 */
package forOffer5;

public class StringInMatrix {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        int[] flag = new int[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (helper(matrix, rows, cols, i, j, str, 0, flag))
                    return true;
            }
        }
        return false;
    }

    private boolean helper(char[] matrix, int rows, int cols, int i, int j, char[] str, int k, int[] flag) {
        int index = i * cols + j;
        // 如果输入不规范(i < 0 || i >= rows || j < 0 || j >= cols)
        // 或者当前找到的这个值不是要找的值(matrix[index] != str[k])
        // 或者这个位置已经找过了(flag[index] == 1)
        // 返回false
        if(i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[k] || flag[index] == 1)
            return false;
        if(k == str.length - 1)
            return true;

        // 标记当前位置已经找过了
        flag[index] = 1;

        // 继续找下一个 下 上 右 左(顺序无所谓啦)
        if(helper(matrix, rows, cols, i+1, j, str, k+1, flag)
                || helper(matrix, rows, cols, i-1, j, str, k+1, flag)
                || helper(matrix, rows, cols, i, j+1, str, k+1, flag)
                || helper(matrix, rows, cols, i, j-1, str, k+1, flag))
            return true;

        // 没有找到下一个, 回溯到上一个, 将当前位置的以走标记清零
        flag[index] = 0;
        return false;
    }
}
