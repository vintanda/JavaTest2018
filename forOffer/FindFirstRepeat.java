/**
 * @Date 2018/08/06
 * @Author LZD
 *
 * 题目描述:
 *  在一个长度为n的数组里的所有数字都在0到n-1的范围内.
 *  数组中某些数字是重复的, 但不知道有几个数字是重复的, 也不知道每个数字重复几次.
 *  请找出数组中第一个重复的数字.
 *  例如, 如果输入长度为7的数组{2,3,1,0,2,5,3}, 那么对应的输出是第一个重复的数字2.
 *
 * 思路：
 *  模拟桶, 因为条件中有一句说长度为n的数组中所有数字都是[0,n-1]中的
 *  所以就可以创建一个boolean类型的数组, 数组中的数的值对应boolean数组的下标
 *  遍历原数组, 出现哪个数, 就将boolean数组中的哪一位置true
 *  如果发现该位已经是true, 就表明之前已经出现过这个数, 就是重复的数
 *
 * 运行性能：
 *  运行时间：12ms
 *  占用内存：9660k
 */
package forOffer4;

public class FindFirstRepeat {
    public static void main(String[] args) {
        int[] res = new int[1];
        System.out.println(new FindFirstRepeat()
                .duplicate(new int[]{2, 4, 1, 0, 6, 3, 5},
                        7, res));
        System.out.println(res[0]);
    }
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if(numbers == null || length == 0)
            return false;
        if(numbers.length == 0)
            return false;
        boolean[] hasNum = new boolean[length];

        for(int num : numbers) {
            if(hasNum[num]) {
                duplication[0] = num;
                return true;
            }
            hasNum[num] = true;
        }
        return false;
    }
}
