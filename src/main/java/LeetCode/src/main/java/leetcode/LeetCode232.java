package LeetCode.src.main.java.leetcode;

import JavaAlgo.src.main.java.datastructure.stack.ArrayStack;

/**
 * 双栈模拟先进先出的队列
 */
public class LeetCode232 {

    ArrayStack<Integer> arrayStack1 = new ArrayStack<>(100);
    ArrayStack<Integer> arrayStack2 = new ArrayStack<>(100);

    //从队尾添加
    public void push(int x) {
        arrayStack2.push(x);

    }

    //队头删除
    public int pop() {
        //先将arrayStack2的元素移到as1,在进行删除
        if (arrayStack1.isEmpty()) {
            //将as2中的元素添加到as1
            while (!arrayStack2.isEmpty()) {
                arrayStack1.push(arrayStack2.pop());
            }
        }
        //从队头删除
        return arrayStack1.pop();
    }

    public int peek() {
        if (arrayStack1.isEmpty()) {
            //将as2中的元素添加到as1
            while (!arrayStack2.isEmpty()) {
                arrayStack1.push(arrayStack2.pop());
            }
        }
        //从队头删除
        return arrayStack1.peek();
    }

    public boolean empty() {
        return arrayStack1.isEmpty() && arrayStack2.isEmpty();
    }

}
