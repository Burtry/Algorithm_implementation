package JavaAlgo.src.main.java.Queue.QueueImpl;


import JavaAlgo.src.main.java.Queue.Queue;

import java.util.Iterator;

/**
 * 单向环形带哨兵的链表方式实现队列
 * @param <E>
 */
public class LinkListQueue<E> implements Queue<E>,Iterable<E>{

    /**
     * 定义节点类
     * @param <E> 元素类型
     */
    private static class Node<E> {
        //保存值的属性
        E value;
        //指向下一节点
        Node<E> next;

        //有参构造
        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }
    //头结点head  首先指向哨兵结点;
    Node<E> head = new Node<>(null,null);

    //尾结点tail  首先指向哨兵节点;
    Node<E> tail = head;

    //在构造方法里面，让tail.next 指向 head 来达成环形(环形链表，尾指向头部)


    public LinkListQueue() {
        tail.next = head;
    }

    @Override
    public boolean offer(E value) {
        Node<E> eNode = new Node<>(value, head);
        tail.next = eNode;
        //新节点作为新的tail
        tail = eNode;

        return true;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    //迭代器
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> p = head.next;
            @Override
            public boolean hasNext() {
                //p不是头结点的时候可以继续往下循环
                return p !=head;
            }

            @Override
            public E next() {
                E value = p.value;
                p = p.next;
                return value;
            }
        };
    }
}
