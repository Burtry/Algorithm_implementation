package LeetCode.src.main.java.leetcode;

import LeetCode.src.main.java.leetcode.Node.ListNode;

/**
 * 环形链表
 * 判断在给出头结点的链表中，判断是否是环形链表，如果是则返回true,否则返回false
 */
public class LeetCode141 {

    /**
     * 快慢指针
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slowNode = head;
        ListNode fastNode = head.next;

        while (slowNode != fastNode) {

            if (fastNode == null || fastNode.next == null) {
                return false;
            }

            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        return true;

    }
}
