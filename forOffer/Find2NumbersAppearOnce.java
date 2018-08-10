/**
 * @Date 2018/07/29
 * @Author LZD
 *
 * 题目描述：
 *  一个整型数组里除了两个数字之外, 其他的数字都出现了偶数次.
 *  请写程序找出这两个只出现一次的数字.
 *
 * 思路：
 *  【链接：https://www.nowcoder.com/questionTerminal/e02fdb54d7524710a7d664d082bb7811 来源：牛客网
 *  首先：位运算中异或的性质：两个相同数字异或 = 0, 一个数和0异或还是它本身.
 *  当只有一个数出现一次时, 我们把数组中所有的数, 依次异或运算,
 *  最后剩下的就是那两个落单的数, 因为成对儿出现的都抵消了.
 *  依照这个思路, 我们来看两个数(我们假设是A和B)出现一次的数组.
 *  我们首先还是先异或, 剩下的数字肯定是A和B异或的结果,
 *  这个结果的二进制中的1, 表现的是A和B的不同的位.
 *  我们就取第一个1所在的位数, 假设是第3位, 接着把原数组分成两组, 分组标准是第3位是否为1.
 *  如此, 相同的数肯定在一个组, 因为相同数字所有位都相同, 而不同的数, 肯定不在一组.
 *  然后把这两个组按照最开始的思路, 依次异或, 剩余的两个结果就是这两个只出现一次的数字.
 *
 * 运行性能：
 *  运行时间：29ms
 *  占用内存：9560k
 */
package forOffer4;

public class Find2NumbersAppearOnce {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 3, 4, 5, 5, 2};
        int[] num1 = new int[]{0,0,0,0};
        int[] num2 = new int[]{0,0,0,0};

        FindNumsAppearOnce(arr, num1, num2);
        System.out.println(num1[0] + " ----- " +num2[0]);
    }

    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array == null || array.length < 2)
            return;

        if(array.length == 2) {
            num1[0] = array[0];
            num2[0] = array[1];
        }

        // 从第一个数字开始进行异或运算
        int bitRes = 0;
        for (int anArray1 : array) {
            bitRes ^= anArray1;
        }

        int bitIndex = findFirstBitEquals1(bitRes);

        // 按照不同位进行分组
        for (int anArray : array) {
            if (bitValue(anArray, bitIndex))
                num1[0] ^= anArray;
            else
                num2[0] ^= anArray;
        }
    }

    // 获取不同位中的最低位
    private static int findFirstBitEquals1(int bitRes) {
        int count = 0;
        while((bitRes & 1) == 0 && count < 32) {
            bitRes = bitRes >> 1;
            count++;
        }
        return count;
    }

    // 判断该位是否为1, 按照1/0将数组分为两个数组
    private static boolean bitValue(int num, int index) {
        return ((num >> index) & 1) == 1;
    }
}
