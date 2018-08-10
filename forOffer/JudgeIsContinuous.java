/**
 * 题目描述：
 *  LL今天心情特别好, 因为他去买了一副扑克牌, 发现里面居然有2个大王, 2个小王(一副牌原本是54张^_^)...
 *  他随机从中抽出了5张牌, 想测测自己的手气, 看看能不能抽到顺子,
 *  如果抽到的话, 他决定去买体育彩票, 嘿嘿!!
 *  “红心A, 黑桃3, 小王, 大王, 方片5”, “Oh My God!”不是顺子.....
 *  LL不高兴了, 他想了想, 决定大\小, 王可以看成任何数字, 并且A看作1, J为11, Q为12, K为13.
 *  上面的5张牌就可以变成“1, 2, 3, 4, 5”(大小王分别看作2和4), “So Lucky!”. LL决定去买体育彩票啦.
 *  现在, 要求你使用这幅牌模拟上面的过程, 然后告诉我们LL的运气如何,
 *  如果牌能组成顺子就输出true, 否则就输出false.
 *  为了方便起见, 你可以认为大小王是0.
 *
 * 思路：
 *  1.一共有5张牌 => 传入数组的长度必须 =5
 *  2.没有非法输入 => 数字必须在 [0-13] 范围内
 *  3.没有重复的数字 => 此处使用为运算, 遍历数组, 传入的数字是多少, 就将第几位置1,
 *    拿到下一个数字n的时候, 用1和记录的数字右移n位做与运算, 如果是1, 则认为重复了.
 *  4.最大最小值的差如果 >=5 则认为不能构成顺子, 如果差值 <5, 则可以使用王进行填充
 *
 * 运行性能：
 *  运行时间：11ms
 *  占用内存：9428k
 */
package forOffer4;

public class JudgeIsContinuous {
    public static void main(String[] args) {
        int[] nums = new int[]{2,4,0,6,7};
        System.out.println(isContinuous(nums));
    }
    private static boolean isContinuous(int [] numbers) {
        if(numbers.length != 5)
            return false;

        // 用来记录最大值和最小值
        int max = -1;
        int min = 14;

        // 用来检查是否有重复的数字
        int flag = 0;

        for(int number : numbers) {
            if(number > 13 || number < 0)
                return false;
            else if(number == 0)
                continue;
            else if(((flag >> number) & 1) == 1)
                return false;
            flag |= (1 << number);
            if(number > max)
                max = number;
            if(number < min)
                min = number;
            if(max - min >= 5)
                return false;
        }
        return true;
    }
}
