package LeetCode.src.main.java.leetcode;

import JavaAlgo.src.main.java.datastructure.heap.MinHeap;

public class LeetCOde215 {
    public static void main(String[] args) {
        System.out.println(new LeetCOde215().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(new LeetCOde215().findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }


    /**
     * 找到numbers中第k大的数字
     * @param numbers 数字集合
     * @param k k
     * @return 第k大的元素
     */
    public int findKthLargest(int[] numbers, int k) {

        MinHeap minHeap = new MinHeap(k);
        //向堆中添加k个元素
        for (int i = 0; i < k; i++) {
            minHeap.offer(numbers[i]);
        }

        for (int i = k; i < numbers.length; i++) {
            if (numbers[i] > minHeap.peek()) {
                //替换堆顶元素
                minHeap.replace(numbers[i]);
            }
        }
        return minHeap.peek();
    }
}
