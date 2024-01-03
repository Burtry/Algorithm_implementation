package JavaAlgo.src.main.java.datastructure.queue.QueueImpl;


import JavaAlgo.src.main.java.datastructure.queue.Queue;

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
    private final Node<E> head = new Node<>(null,null);
    //尾结点tail  首先指向哨兵节点;
    Node<E> tail = head;
    int size = 0;   //节点数
    private int capacity = Integer.MAX_VALUE;   //容量

    //在构造方法里面，让tail.next 指向 head 来达成环形(环形链表，尾指向头部)
    //初始化代码块,减少构造方法里面的重复代码
    {
        tail.next = head;
    }

    public LinkListQueue() {}

    //带惨构造，指定队列容量否则没有限制
    public LinkListQueue(int capacity) {
        this.capacity = capacity;
    }



    @Override
    public boolean offer(E value) {
        //检查容量
        if(isFull()) {
            return false;
        }
        Node<E> eNode = new Node<>(value, head);
        tail.next = eNode;
        //新节点作为新的tail
        tail = eNode;
        size++;
        return true;
    }

    @Override
    public E poll() {
        if(isEmpty()){
            return null;
        }
        Node<E> first = head.next;
        head.next = first.next;     //将头结点直线first的下一个节点，逻辑上就把first从队列中删除了。
        //判断如果是队列中只剩最后一个元素,tail要指向head
        if(first == tail) {
            tail = head;
        }
        size--;
        return first.value;
    }

    @Override
    public E peek() {
        //如果是头结点，则返回null
        if(isEmpty()) {
            return null;
        }
        //获取第一个节点的值
        return head.next.value;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
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
