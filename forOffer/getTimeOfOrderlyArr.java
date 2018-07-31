/**
 * @Date 2018/07/24
 * @Author LZD
 *
 * 题目描述：
 *  统计一个数字在排序数组中出现的次数。
 *
 * 思路：
 *  第一种常规思路：
 *  1.二分查找,因为是有序数组
 *  2-1.找到这个数了,向前向后查找到该数的第一个和最后一个的下标,相减后+1即这个数的个数,返回
 *  2-2.没找着,返回0
 *
 *  第二种在讨论区看到的：
 *  是找到它前一个最后的位置和后一个的第一个位置...感觉很骚气,和常规思路没啥区别哦...
 *  而且还面临着没有那两个数的风险
 *
 *  第三种就是第二种给我的灵感：
 *  写一个函数用来查找第一个位置,然后找到它和它下一个的第一个位置,相减就可以,
 *  这个的好处就是写一个函数并调用两次就可以,只用找第一个位置
 *  但是面临着没有那个数的风险
 *
 * 运行性能：
 *  时间复杂度还是蛮高的...两层while循环嵌套
 *  运行时间：23ms
 *  占用内存：9536k
 * [!!!!xie ge zhu shi shu ru fa zha le san ci smile.jpg...
 */
package forOffer3;

public class getTimeOfOrderlyArr {
    public static void main(String[] args) {
        int[] ints = new int[]{3};
        System.out.println(new getTimeOfOrderlyArr().GetNumberOfK(ints, 0));
    }

    public int GetNumberOfK(int [] array , int k) {
        if(array == null)
            return 0;
        if(array.length == 0)
            return 0;
        if(array.length == 1 && array[0] == k)
            return 1;
        int length = array.length;
        int left = 0, right = length - 1;
        int mid;
        int res = 0;
        while (left <= right) {
            mid = (left + right) >> 1;
            // 找到了k
            if(array[mid] == k) {
//                System.out.println(mid);
                int tmp = mid;
                int begin = mid, end = mid;

                // 向前找
                while(tmp >= 0 && array[tmp] == k) {
                    begin = tmp--;
                }

                // 向后找
                tmp = mid;
                while(tmp <= length && array[tmp] == k) {
                    end = tmp++;
                }

                // 得到结果最后一个和第一个下标相减后+1
                res = end - begin + 1;
                break;
            }else if(array[mid] > k) {
                // 在左边
                right = mid - 1;
            }else {
                // 在右边
                left = mid + 1;
            }
        }

        return res;
    }

}
