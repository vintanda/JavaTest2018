/**
 * @Date 2018/08/09
 * @Author LZD
 *
 * 题目描述：
 *  地上有一个m行和n列的方格.
 *  一个机器人从坐标(0,0)的格子开始移动, 每一次只能向左, 右, 上, 下四个方向移动一格,
 *  但是不能进入行坐标和列坐标的数位之和大于k的格子.
 *  例如, 当k为18时, 机器人能够进入方格(35, 37), 因为3+5+3+7 = 18.
 *  但是, 它不能进入方格(35,38), 因为3+5+3+8 = 19.请问该机器人能够达到多少个格子?
 *
 * 思路：
 *  就是回溯...和矩阵那个题几乎一样
 *  在处理数据的时候写一个方法得到数字每一位的和
 *
 * 运行性能：
 *  运行时间：12ms
 *  占用内存：9420k
 */
package forOffer5;

public class MovingCount {
    public static void main(String[] args) {
        System.out.println(new MovingCount().movingCount(18, 6, 6));
    }
    public int movingCount(int threshold, int rows, int cols) {
        if(threshold <= 0 || rows < 0 || cols < 0)
            return 0;
        int[][] flag = new int[rows][cols];
        return helper(0 , 0, rows, cols, flag, threshold);
    }

    private int helper(int i, int j, int rows, int cols, int[][] flag, int threshold) {
        if(i < 0 || i >= rows || j < 0 || j >= cols || flag[i][j] == 1 || numSum(i) + numSum(j) > threshold)
            return 0;
        flag[i][j] = 1;
        return helper(i, j + 1, rows, cols, flag, threshold)
                + helper(i, j - 1, rows, cols, flag, threshold)
                + helper(i + 1, j, rows, cols, flag, threshold)
                + helper(i - 1, j, rows, cols, flag, threshold)
                + 1;
    }

    private int numSum(int i) {
        int sum = 0;
        do{
            sum += i % 10;
        }while ((i = i / 10) > 0);
        return sum;
    }
}
