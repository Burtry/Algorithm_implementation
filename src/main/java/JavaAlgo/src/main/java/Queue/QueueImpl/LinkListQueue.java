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
        //元素
        E value;
        //指向下一节点
        Node<E> next;

        //有参构造
        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }




    @Override
    public boolean offer(E value) {
        return false;
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

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
