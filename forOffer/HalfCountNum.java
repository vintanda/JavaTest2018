/**
 * @Author LZD
 * @Date 2018/06/11
 *
 * 题目描述：
 *  数组中有一个数字出现的次数超过数组长度的一半,请找出这个数字.
 *  例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}.
 *  由于数字2在数组中出现了5次,超过数组长度的一半,因此输出2.如果不存在则输出0.
 *
 * 思路：
 *  1)getMoreHalfCountNumber方法的思路：[O(N)]
 *      对一个变量赋初始值为的一个数num,遍历数组,如果遍历的这个数和正在累计的数是同一个数,则count++,否则count--;
 *      一旦count变为0,就为num赋一个新值也就是遍历到的下一个数;
 *      遍历结束的那个num值可能就是所求的值,但是也有可能不是,也就是这个数组中不存在满足要求的数;
 *      所以需要一个证明的过程,也就是再进行一次遍历,将数组中的每个数和num进行比较,
 *      如果num出现的次数大于数组长度的一半,则返回那个数字,否则返回0.
 *  2)getMoreHalfCountNumberByArrays方法的思路：[O(NlogN)]
 *      一个数组在排序后,如果存在一个数字出现次数大于数组长度的一半,那中间的那个数一定是那个数;
 *      于是就调用了Arrays类中的sort方法,所以时间复杂度是NlogN;
 *      得到排序后数组最中间的那个数后再进行一次遍历比较.
 *
 * 性能分析：
 *  两种方法的测试运行结果在方法上,时间都是15ms,但从算法的时间复杂度上讲,第一种是优于第二种的.
 */
package forOffer2;

import java.util.Arrays;

public class HalfCountNum {
    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 5, 5, 2, 2, 2, 2, 3};
        System.out.println(getMoreHalfCountNumber(numbers));
        System.out.println(getMoreHalfCountNumberByArrays(numbers));
    }

    /*
    运行时间：15ms
    占用内存：9292k
     */
    public static int getMoreHalfCountNumber(int[] array) {
        if(array == null || array.length == 0)
            return 0;
        int num = array[0];
        int count = 1;
        for(int i = 1;i < array.length;i++) {
            if(num == array[i])
                count++;
            else
                count--;
            if(count == 0) {
                num = array[i];
                count = 1;
            }
        }

        // Verifying
        count = 0;
        for(int i = 0;i < array.length;i++) {
            if(num == array[i])
                count++;
        }
        return count*2 > array.length ? array[array.length/2] : 0;
    }

    /*
    运行时间：15ms
    占用内存：9460k
     */
    public static int getMoreHalfCountNumberByArrays(int[] array) {
        if(array == null || array.length == 0)
            return 0;
        Arrays.sort(array);

        // Verifying
        int count = 0;
        for(int i = 0;i < array.length;i++) {
            if(array[i] == array[array.length / 2]) {
                count++;
            }
        }
        return count*2 > array.length ? array[array.length/2] : 0;
    }
}
