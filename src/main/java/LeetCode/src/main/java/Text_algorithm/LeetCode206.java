package LeetCode.src.main.java.Text_algorithm;
import LeetCode.src.main.java.Text_algorithm.Node.ListNode;


/**
 * 反转链表
 */
public class LeetCode206 {

    /**
     * 方法一
     * @param head
     * @return
     */
    public ListNode reserveList1(ListNode head) {
        ListNode n1 = null;
        ListNode p = head;
        while (p != null) {
            n1 = new ListNode(p.val, n1);
            p = p.next;
        }
        return n1;
    }

    /**
     * 方法二
     * @param head
     * @return
     */
    public ListNode reserveList2(ListNode head) {
        List list1 = new List(head);
        List list2 = new List(null);

        while (true) {
            ListNode node = list1.removeFirst();
            if (node == null) {
                break;
            }
            list2.addFirst(node);
        }
        return list2.head;
    }

    static class List{
        ListNode head;

        public List(ListNode head) {
            this.head = head;
        }

        public void addFirst(ListNode node) {
            node.next = head;
            head = node;
        }

        public ListNode removeFirst() {
            ListNode first = head;
            if (first != null) {
                head = first.next;
            }
            return first;
        }
    }

    /**
     * 方法三 - 递归
     * @param p
     * @return
     */
    public ListNode reserveList3(ListNode p) {

        if (p ==null || p.next == null) {
            return p; //最后的节点
        }
        ListNode last = reserveList(p.next);
        p.next.next = p;
        p.next = null;
        return last;
    }

    /**
     * 方法四
     * @param o1
     * @return
     */
    public ListNode reserveList4(ListNode o1) {

        //当为空链表或一个元素时，直接返回即可
        if (o1 == null || o1.next == null) {
            return o1;
        }

        ListNode n1 = o1;
        ListNode o2 = o1.next;

        while (o2 != null) {
            o1.next = o2.next;
            o2.next = n1;
            n1 = o2;
            o2 = o1.next;
        }
        return n1;
    }


    /**
     * 方法五
     * @param
     * @return
     */
    public ListNode reserveList(ListNode o1) {
        //当为空链表或一个元素时，直接返回即可
        if (o1 == null || o1.next == null) {
            return o1;
        }
        ListNode n1 = null;
        while (o1 != null) {
            ListNode o2 = o1.next;
            o1.next = n1;
            n1 = o1;
            o1 = o2;
        }
        return n1;

    }

    public static void main(String[] args) {
        ListNode node3 = new ListNode(3, null);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        System.out.println(node1);
        ListNode n1 = new LeetCode206().reserveList(node1);
        System.out.println(n1);
    }
}
