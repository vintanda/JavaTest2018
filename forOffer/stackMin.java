/**
 * @Author LZD
 * @Date 2018/05/02
 *
 * 题目描述：
 *  定义栈的数据结构,请在该类型中实现一个能够得到栈最小元素的min函数.
 * 思路：
 *  这个题一开始就没明白啥意思...因为说要实现一个能找到最小数的栈,给了Stack包,还让实现push,pop方法,就有点懵
 *  然后看解答里面说因为要实现取出最小的值,还要满足时间复杂度为O(n),emmmm其实我觉得不这样做也可以的...
 *  如果只有一个min方法,完全可以遍历一次给定的栈,把所有的值放在一个ArrayList里面然后再放回去就行了...
 *  但是看解答里面用了两个栈,一个数据栈和一个最小值栈,同时也实现了push,pop方法,发现这样很方便,
 *  【虽然我还是对这个题抱有一定的无语态度的...因为到最后还是不明白这个题在干嘛...
 */
package forOffer;

import java.util.Stack;

public class stackMin {

    // 定义两个栈
    Stack<Integer> dataStack = new Stack<>();
    Stack<Integer> minStacak = new Stack<>();
    Integer tmp = null;

    public void push(int node) {
        if(tmp != null) {
            if(node < tmp) {
                minStacak.push(node);
                tmp = node;
            }
            dataStack.push(node);
        }else {
            tmp = node;
            dataStack.push(node);
            minStacak.push(node);
        }
    }

    public void pop() {
        int dataNum = dataStack.pop();
        int minNum = minStacak.pop();
        if(dataNum != minNum)
            minStacak.push(minNum);
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStacak.peek();
    }
}
