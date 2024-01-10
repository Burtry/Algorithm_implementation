package LeetCode.src.main.java.leetcode;

import JavaAlgo.src.main.java.datastructure.queue.TextQueue.LinkedListQueue;

/**
 * 单队列模拟栈
 */
public class LeetCode225 {
    LinkedListQueue<Integer> queue = new LinkedListQueue<>(100);

    private int size;

    public void push(int x) {

        queue.offer(x);
        for (int i = 0; i < size; i++) {
            queue.offer(queue.poll());
        }
        size++;
    }

    public int pop() {
        size--;
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
