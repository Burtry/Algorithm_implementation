package JavaAlgo.src.main.java.datastructure.deque;

import java.util.Iterator;

public class LinkedListDeque<E> implements Deque<E>,Iterable<E>{

    /**
     * 定义节点类
     * @param <E> 元素类型
     */
    private static class Node<E> {
        //指向上一节点
        Node<E> prev;
        //保存值的属性
        E value;
        //指向下一节点
        Node<E> next;
        //有参构造
        public Node(Node<E> prev,E value,Node<E> next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    //容量
    int capacity;
    //队列中元素个数
    int size;

    Node<E> sentinel = new Node<>(null, null, null);

    //构造
    public LinkedListDeque(int capacity) {
        this.capacity = capacity;
        sentinel.prev = sentinel;
        sentinel.next = sentinel;

    }

    @Override
    // a added b
    public boolean offerFirst(E e) {
        if (isFull()) {
            return false;
        }
        Node<E> a = sentinel;
        Node<E> b = sentinel.next;
        Node<E> added = new Node<>(a, e, b);
        a.next = added;
        b.prev = added;
        size++;
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        if (isFull()) {
            return false;
        }
        Node<E> b = sentinel;
        Node<E> a = sentinel.prev;
        Node<E> added = new Node<>(a, e, b);
        a.next = added;
        b.prev = added;
        size++;
        return true;
    }

    //a removed b
    @Override
    public E pollFirst() {
        if (isEmpty()) {
            return null;
        }
        Node<E> a = sentinel;
        Node<E> removed = a.next;
        Node<E> b = removed.next;
        a.next = b;
        b.prev = a;
        size--;
        return removed.value;
    }

    //a removed b
    @Override
    public E pollLast() {
        if (isEmpty()) {
            return null;
        }
        Node<E> b = sentinel;
        Node<E> removed = sentinel.prev;
        Node<E> a = removed.prev;
        a.next = b;
        b.prev = a;
        size--;
        return removed.value;
    }

    @Override
    public E peekFirst() {
        if (isEmpty()) {
            return null;
        }
        return sentinel.next.value;
    }

    @Override
    public E peekLast() {
        if (isEmpty()) {
            return null;
        }
        return sentinel.prev.value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            Node<E> p = sentinel.next;

            @Override
            public boolean hasNext() {
                return p != sentinel;
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
