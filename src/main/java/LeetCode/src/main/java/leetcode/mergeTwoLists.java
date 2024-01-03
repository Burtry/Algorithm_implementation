package LeetCode.src.main.java.leetcode;

import LeetCode.src.main.java.leetcode.Node.ListNode;

//合并两个升序的链表
public class mergeTwoLists {
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        //创建一个伪头结点
        ListNode dum = new ListNode(), cur = dum; //cur指向dum
//        循环合并,当list1或list2为null时，跳出循环
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                //cur的后继节点指向list1,list1向前走一步
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            //节点cur向前走一步
            cur = cur.next;
        }
        //合并剩余结尾：
        cur.next = list1 != null ? list1 : list2;
        return dum.next;
    }
}



