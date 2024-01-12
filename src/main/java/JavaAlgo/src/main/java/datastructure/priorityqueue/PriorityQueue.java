package JavaAlgo.src.main.java.datastructure.priorityqueue;

import JavaAlgo.src.main.java.datastructure.queue.Queue;

/**
 * 基于无序数组实现优先队列
 */
public class PriorityQueue<E extends Priority> implements Queue<E> {

    Priority[] array;
    int size;

    public PriorityQueue(int capacity) {
        array = new Priority[capacity];
    }


    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        array[size] = value;
        size++;
        return true;
    }

    //返回优先级最高的索引值
    private int selectMax() {
        int max = 0;
        for (int i = 1; i < size; i++) {
            if(array[i].priority() > array[max].priority()) {
                max = i;
            }
        }
        return max;
    }

    //删除指定索引处的值
    private void remove(int index) {
        if (index < size - 1) {
            //移动
            System.arraycopy(array,index + 1, array, index,size - 1 - index);
        }
    }
    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        int max = selectMax();
        E e = (E) array[max];
        remove(max);
        return e;

    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        int max = selectMax();
        return (E) array[max];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }
}
