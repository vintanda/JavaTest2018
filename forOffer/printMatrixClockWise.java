/**
 * @Author LZD
 * @Date 2018/05/02
 *
 * 题目描述：
 *  输入一个矩阵,按照从外向里以顺时针的顺序依次打印出每一个数字.
 *  例如,如果输入如下矩阵：
 *       1  2  3  4
 *       5  6  7  8
 *       9 10 11 12
 *      13 14 15 16
 *  则依次打印出数字
 *      1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * 思路：
 *  用左上和右下的坐标定位出一次要旋转打印的数据,一次旋转打印结束后,往对角分别前进和后退一个单位;
 *  需要加入条件判断,防止出现单行或者单列的情况.
 */
package forOffer;

import java.util.ArrayList;

public class printMatrixClockWise {
    public static void main(String[] args) {
        int[][] matrix = new int[3][4];
        int k = 0;
        for(int i = 0;i < matrix.length;i++) {
            for(int j = 0;j < matrix[0].length;j++)
                matrix[i][j] = k++;
        }
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        for(int i = 0;i < matrix.length;i++) {
            for(int j = 0;j < matrix[0].length;j++)
                System.out.print(matrix[i][j]);
            System.out.println();
        }
        ArrayList<Integer> arrayList = printMatrix(matrix);
        System.out.println(arrayList);
    }

    private static ArrayList<Integer> printMatrix(int [][] matrix) {
        if(matrix == null)
            return null;
        ArrayList<Integer> result = new ArrayList<>();
        int n = matrix.length;
        if(n == 0)
            return null;
        int m = matrix[0].length;
        if(m == 0)
            return null;

        // 遍历
        // 根据矩阵的行列数中较少的数决定是多少层循环
        int layer = (Math.min(n, m) - 1) / 2 + 1;
        for(int i = 0;i < layer;i++) {
            // 对四个边进行遍历
            // 行 --- 从左至右
            for(int j = i;j < m - i;j++)
                result.add(matrix[i][j]);
            // 列 --- 从上到下
            for(int k = i + 1;k < n - i;k++)
                result.add(matrix[k][m - i - 1]);
            // 行 --- 从右至左
            for(int j = m - i - 2;(j >= i) && (n - i - 1 != i);j--)
                result.add(matrix[n - i - 1][j]);
            // 列 --- 从下到上
            for(int k = n - i - 2;(k > i) && (m - i -1 != i);k--)
                result.add(matrix[k][i]);
        }

        return result;
    }
}
