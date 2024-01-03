package JavaAlgo.src.main.java.datastructure.linkList.DoublyLinkedListSentinel;

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

    /**
     * 删除头部
     */
    public void removeFirst() {
        Node removed = sentinel.next;
        if (removed == sentinel) {
            throw new IllegalArgumentException("非法");
        }
        Node a = removed.prev;
        Node b = removed.next;
        a.next = b;
        b.prev = a;

    }

    /**
     * 删除尾部
     */
    public void removeLast() {
        Node removed = sentinel.prev;
        if (removed == sentinel) {
            throw new IllegalArgumentException("异常");
        }
        Node b = removed.prev;
        Node a = sentinel;

        b.next = a;
        a.prev = b;

    }


    /**
     * 根据值删除节点
     * @param value 待删除的值
     */
    public void removeByValue(Integer value) {
        Node removed = findValue(value);
        if (removed == null) {
            return; //不用删
        }
        //找到了
        Node a = removed.prev;
        Node b = removed.next;
        a.next = b;
        b.prev = a;
    }

    private Node findValue(Integer value) {
        Node p = sentinel.next;
        while (p != sentinel) {
            if (p.value == value) {
                return p;
            }
            p = p.next;
        }
        return null;
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
