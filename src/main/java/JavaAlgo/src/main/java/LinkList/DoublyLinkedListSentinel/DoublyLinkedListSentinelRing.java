package JavaAlgo.src.main.java.LinkList.DoublyLinkedListSentinel;

import java.util.Iterator;

/**
 * 双向环形链表(带哨兵)
 */
public class DoublyLinkedListSentinelRing implements Iterable<Integer>{

    /**
     * 首先定义一个节点类
     */
    private static class Node {
        Node prev;
        Integer value;
        Node next;

        public Node(Node prev, Integer value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }
    //哨兵
    Node sentinel = new Node(null,-1,null);

    //在双向环形链表的构造器中来初始化哨兵节点
    public DoublyLinkedListSentinelRing() {
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }


    /**
     * 添加到头部
     * @param value 待添加值
     */
    public void addFirst(Integer value) {
        Node a = sentinel;
        Node b = sentinel.next;

        Node add = new Node(a, value, b);
        a.next = add;
        b.prev = add;

    }

    /**
     * 添加到尾部
     * @param value 待添加值
     */
    public void addLast(Integer value) {
        Node b = sentinel;
        Node a = sentinel.prev;

        Node added = new Node(a, value, b);
        a.next = added;
        b.prev = added;
    }










    //迭代器
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = sentinel.next;

            @Override
            public boolean hasNext() {
                return p != sentinel;
            }

            @Override
            public Integer next() {
                Integer value = p.value;
                p = p.next;
                return value;
            }
        };
    }
}
