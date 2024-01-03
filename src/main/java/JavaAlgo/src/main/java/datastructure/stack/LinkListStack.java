package JavaAlgo.src.main.java.datastructure.stack;

import java.util.Iterator;

public class LinkListStack<E> implements Stack<E> ,Iterable<E>{

    static class Node<E> {
        E value;
        Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    private int capacity;
    private int size;

    Node<E> head = new Node<>(null, null);


    public LinkListStack(int capacity) {
        this.capacity = capacity;
    }

    //  1
    // head -> 2 -> 1 -> null
    @Override
    public boolean push(E value) {
        if (isFull()) {
            return false;
        }
        head.next = new Node<>(value, head.next);
        size++;
        return true;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        Node<E> node = head.next;
        head.next = node.next;
        size--;
        return node.value;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        Node<E> node = head.next;
        return node.value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return capacity == size;
    }

    @Override
    public Iterator<E> iterator() {

        return new Iterator<>() {
            Node<E> p = head.next;

            @Override
            public boolean hasNext() {
                return p != null;
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
