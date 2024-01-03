package JavaAlgo.src.main.java.datastructure.linkList.DoublyLinkedListSentinel;

import java.util.Iterator;

/**
 * 双向链表(带哨兵)
 */
public class DoublyLinkedListSentinel implements Iterable<Integer>{

    /**
     * 节点类
     */
    private static class Node {
        Node prev;
        int value;
        Node next;

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 双向链表的基本结构
     */

    //在链表类中加入头哨兵和尾哨兵
    private Node head;
    private Node tail;
    //构造器    在构造器中赋初始值
    public DoublyLinkedListSentinel() {
         head = new Node(null,601,null);
         tail = new Node(null,699,null);
         head.next = tail;
        tail.prev = head;
    }

    /**
     * 工具类,用于查询指定索引位置的节点
     */
    private Node findNode(int index) {
        int i = -1;     //-1出的节点为头结点
        for (Node p = head; p != tail; p = p.next, i++) {
            if(i == index) {
                return p;
            }
        }
        //没有找到返回null
        return null;
    }


    /**
     * 实现方法
     */

    public void addFirst(int value) {
        insert(0,value);

    }

    public void removeFirst() {
        remove(0);

    }

    public void addLast(int value) {
        Node last = tail.prev;
        Node inserted = new Node(last, value, tail);

        last.next = inserted;
        tail.prev = inserted;

    }

    public void removeLast() {
        Node last = tail.prev;
        if (last == head) {
            throw illegalIndex(0);
        }
        Node prev = last.prev;

        prev.next = tail;
        tail.prev = prev;


    }

    public void insert(int index, int value) {
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw illegalIndex(index);
        }
        Node next = prev.next;
        Node newNode = new Node(prev, value, next);
        prev.next = newNode;
        next.prev = newNode;

    }

    public void remove(int index) {
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw illegalIndex(index);
        }
        Node removed = prev.next;
        if (removed == tail) {
            throw illegalIndex(index);
        }
        Node next = removed.next;

        prev.next = next;
        next.prev = prev;

    }

    //异常情况
    private IllegalArgumentException illegalIndex(int index) {
        return new IllegalArgumentException(
                String.format("index [%d] 不合法 %n",index));
    }

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head.next;
            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }

}
