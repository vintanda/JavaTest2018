/**
 * @Date 2018/08/04
 * @Author LZD
 *
 * 题目描述：
 *  牛客最近来了一个新员工Fish, 每天早晨总是会拿着一本英文杂志, 写些句子在本子上.
 *  同事Cat对Fish写的内容颇感兴趣, 有一天他向Fish借来翻看, 但却读不懂它的意思.
 *  例如:“student. a am I”.
 *  后来才意识到, 这家伙原来把句子单词的顺序翻转了, 正确的句子应该是"I am a student."
 *  Cat对一一的翻转这些单词顺序可不在行, 你能帮助他么?
 *
 * 思路：
 *  发现排序之后, 单词内顺序不变, 但单词间的顺序逆置.
 *  就将每个单词提取出来, 保留空格, 第N个单词倒数第N个输出.
 *
 * 运行性能：
 *  运行时间：14ms
 *  占用内存：9564k
 */
package forOffer4;

public class ReverseTheWordInSentence {
    public String ReverseSentence(String str) {
        if(str == null)
            return "";
        if(str.trim().equals(""))
            return str;

        String[] words = str.split(" ");

        StringBuilder builder = new StringBuilder();
        for(int i = words.length;i > 0;i--) {
            builder.append(words[i - 1]);
            if(i > 1)
                builder.append(" ");
        }
        return builder.toString();
    }
}
