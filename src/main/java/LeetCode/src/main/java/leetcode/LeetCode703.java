package LeetCode.src.main.java.leetcode;

import JavaAlgo.src.main.java.datastructure.heap.MinHeap;

/**
 * 求数据流中的第k大的数据(堆的重要应用之一的题目)
 */
public class LeetCode703 {

    private MinHeap minHeap;

    //构造函数中初始化小顶堆
    public LeetCode703(int[] nums, int k) {
        minHeap = new MinHeap(k);

        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (!minHeap.isFull()) {
            //不满
            minHeap.offer(val);
        } else if (val > minHeap.peek()) {
            minHeap.replace(val);
        }
        return minHeap.peek();

    }

    public static void main(String[] args) {
        LeetCode703 text = new LeetCode703(new int[]{4,5,8}, 3);
        System.out.println(text.add(3));
        System.out.println(text.add(5));
        System.out.println(text.add(10));
        System.out.println(text.add(9));
        System.out.println(text.add(4));


    }
}
