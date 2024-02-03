package LeetCode.src.main.java.leetcode;

import LeetCode.src.main.java.leetcode.Node.ListNode;
import LeetCode.src.main.java.leetcode.structure.MinHeap;

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



}

