package LeetCode.src.main.java.leetcode;

import LeetCode.src.main.java.leetcode.Node.ListNode;

/**
 * 合并多个有序链表
 */
public class LeetCode23 {

    public ListNode mergeKLists(ListNode[] lists) {

        MinHeap heap = new MinHeap(lists.length);
        //将链表的头结点加入到小顶堆
        for (ListNode h : lists) {
            if (h != null) {
                heap.offer(h);
            }
        }

        ListNode s = new ListNode(-1, null);
        ListNode t = s;
        while (!heap.isEmpty()) {
            ListNode min = heap.poll();
            t.next = min;
            t = min;
            if (min.next != null) {
                heap.offer(min.next);
            }
        }
        return s.next;

    }


    public static void main(String[] args) {

        ListNode[] lists = {
                ListNode.of(1,4,5),
                ListNode.of(1,3,4),
                ListNode.of(2,6),
                null,
        };

        ListNode m = new LeetCode23().mergeKLists(lists);
        System.out.println(m);
    }


    /**
     * 小顶堆的实现
     */
}

class MinHeap {
    ListNode[] array;
    int size;

    public MinHeap(int capacity) {
        array = new ListNode[capacity];
    }

    public boolean offer(ListNode value) {
        if (isFull()) {
            return false;
        }
        int child = size++;

        int parent = (child - 1) / 2;
        while (child > 0 && value.val < array[parent].val) {
            array[child] = array[parent];
            child = parent;
            //找到下一个parent
            parent = (child - 1) / 2;
        }
        array[child] = value;
        return true;
    }

    private void swap(int i, int j) {
        ListNode tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    private void down(int parent) {

        int left = 2 * parent + 1;
        int right = left + 1;
        int min = parent;
        if (left < size && array[left].val < array[min].val) {
            min = left;
        }
        if (right < size && array[right].val < array[min].val) {
            min = right;
        }
        if (min != parent) {
            swap(min,parent);
            down(min);
        }

    }

    public ListNode poll() {
        if (isEmpty()) {
            return null;
        }
        //1、交换
        swap(0,size - 1);
        size--;
        ListNode e = array[size];
        array[size] = null ;    //help GC

        //2.下潜
        down(0);

        return e;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }
}
