/**
 * @Author LZD
 * @Date 2018/07/03
 *
 * 题目描述：
 *  在一个字符串(0 <= 字符串长度 <= 10000,全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置;
 *  如果没有则返回 -1.
 *
 * 思路：
 *  使用hashMap类型进行存储,存储每个字符出现的次数,每遍历一个字符都对当前字符进行判断,
 *  如果已经有该字符,对其出现次数进行自增操作后再次添加进去;
 *  如果不存在则将该字符添加进去,并且将出现次数赋为1.
 *  添加结束后,将字符串进行二次遍历,将每个字符的出现次数从hashMap中取得并判断是否是只出现了一次,
 *  如果是则直接返回,如果不是则继续遍历直到遍历结束.
 *  题目中还提到说如果没有只出现过一次的字符则返回-1,
 *  那么要添加一个判断对是否遍历所有字符后仍没有找到只出现了一次的字符.
 *
 * 性能：
 *  运行时间：59ms
 *  占用内存：9756k
 *
 */
package forOffer3;

import java.util.LinkedHashMap;

public class firstOneTimeChar {
    public static void main(String[] args) {
        String str = "aaaaaaaaaa";
        System.out.println(getTheChar(str));
    }

    public static int getTheChar(String str) {
        if(null == str || "".equals(str))
            return -1;
        int index = 0;
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

        // 遍历字符串,将字母和出现次数添加到集合中
        for(int i = 0;i < str.length();i++) {
            if(map.containsKey(str.charAt(i))) {
                int time = map.get(str.charAt(i));
                map.put(str.charAt(i), ++time);
            }else {
                map.put(str.charAt(i), 1);
            }
        }

        int i = 0;
        for (Character ch : str.toCharArray()) {
            if(map.get(ch) == 1) {
                index = i;
                break;
            }
            i++;
        }

        // 没有只出现了一次的字符
        if((i == str.length()) && (index != i))
            return -1;

        return index;

    }
}
