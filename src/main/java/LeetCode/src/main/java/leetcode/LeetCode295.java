package LeetCode.src.main.java.leetcode;

/**
 * 利用堆来实现求数据流中的中位数
 */

import LeetCode.src.main.java.leetcode.structure.Heap;

import java.util.Arrays;

/**
 * 为了保证两边数据量的平衡
 * 两边个数一样时，左边个数加一
 * 两边个数不一样时，右边个数加一
 * 但是，随便一个数能直接加入吗？
 * ●左边个数加一时，应该挑右边最小的加入
 * ●右边个数加一时，应该挑左边最大的加入
 */
public class LeetCode295 {


    public void addNum(int val) {
        if (left.size() == right.size()) {
            right.offer(val);
            left.offer(right.poll());
        } else {
            left.offer(val);
            right.offer(left.poll());
        }
    }

    public double findMedian() {
        if (left.size() == right.size()) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return left.peek();
        }
    }

    private Heap left = new Heap(10,true);
    private Heap right = new Heap(10,false);



    @Override
    public String toString() {
        int size = left.size;
        int[] left = new int[size];
        for (int i = 0; i < left.length; i++) {
            left[size - 1 - i] = this.left.array[i];
        }
        int[] right = Arrays.copyOf(this.right.array, this.right.size);
        return Arrays.toString(left) + " <-> " + Arrays.toString(right);
    }

    public static void main(String[] args) {

        LeetCode295 text = new LeetCode295();

        text.addNum(1);
        text.addNum(2);
        text.addNum(3);
        text.addNum(4);
        text.addNum(5);
        System.out.println(text);
        System.out.println(text.findMedian());
        text.addNum(4);
        System.out.println(text);
        System.out.println(text.findMedian());

    }
}
