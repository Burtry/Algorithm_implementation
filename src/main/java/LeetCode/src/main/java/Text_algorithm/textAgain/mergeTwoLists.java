package LeetCode.src.main.java.Text_algorithm.textAgain;

public class mergeTwoLists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        ListNode List = new ListNode(),cur = List;
        while (list1 != null && list2 !=null) {
            if(list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            }else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 !=null?list1:list2;
        return List.next;
    }
}
