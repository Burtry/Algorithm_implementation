package JavaAlgo.src.main.java.datastructure.priorityqueue;

import JavaAlgo.src.main.java.datastructure.queue.Queue;

/**
 * 基于大顶堆实现优先队列
 *
 * 大顶堆的特点:任意节点C与它的父节点P符合P.value >= C.value
 *
 * //堆的底层由数组实现
 * 堆的特征:如果从索引为0开始存储节点数据:
 *      当 i > 0 时,节点i的父节点为floor(i-1)/2,
 *      节点i的左子节点为2i,右子节点为2i+1, 但它们得 < size
 */
public class PriorityQueue3<E extends Priority> implements Queue<E> {

    Priority[] array;
    int size;

    public PriorityQueue3(int capacity) {
        array = new Priority[capacity];
    }


    /**
     * 入队新元素，加入到数组末尾(索引位置child)
     * 不断比较新元素与它父节点(parent)的优先级
     *      -如果父节点的优先级低，将父节点向下移动，移动到child位置，并且找到下一个parent
     *      -直到父节点的优先级更高或者child == 0
     * @param value 待插入值
     * @return true or false
     */
    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        int child = size++;

        int parent = (child - 1) / 2;
        while (child > 0 && value.priority() > array[parent].priority()) {
            array[child] = array[parent];
            child = parent;
            //找到下一个parent
            parent = (child - 1) / 2;
        }
        array[child] = value;
        return true;

    }

    /**
     * 步骤：
     * 1.交换堆顶和尾部元素,让尾部元素出队
     * 2.(下潜)
     *      -从堆顶开始，将父元素与两个孩子比较，大的进行交换
     *      -直到父元素大于两个孩子，或者没有孩子为止
     * @return true or false
     */

    //交换
    private void swap(int i, int j) {
        Priority tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    //下潜
    private void down(int parent) {

        int left = 2 * parent + 1;
        int right = left + 1;

        //假设父元素优先级最高
        int max = parent;
        if (left < size && array[left].priority() > array[max].priority()) {
            max = left;
        }
        if (right < size && array[right].priority() > array[max].priority()) {
            max = right;
        }
        //当max不等于parent时，说明进行了max发生了变换，max被赋值成了左右孩子的最大值
        if (max != parent) {    //有孩子比父亲大
            //然后进行交换
            swap(max,parent);
            //将max作为父元素进行递归
            down(max);
        }

    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        //1、交换
        swap(0,size - 1);
        size--;
        Priority e = array[size];
        array[size] = null ;    //help GC

        //2.下潜
        down(0);

        return (E) e;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return (E) array[0];
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
