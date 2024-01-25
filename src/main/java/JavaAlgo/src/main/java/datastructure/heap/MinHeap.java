package JavaAlgo.src.main.java.datastructure.heap;

import java.util.Arrays;

/**
 * 顶堆实现思路:
 * 1.首先创建数组用来模拟堆的实现,并且进行初始化
 * 2.建堆(heapify)的实现
 * 3.建堆的实现中需要进行下潜(down)实现
 * 4.下潜进行交换(swap)实现
 * 5.各种方法的实现:
 *  (1).peek()获取顶堆实现
 *  (2).pool()删除堆顶元素
 *  (3).replace()替换堆顶元素
 *  (4）offer()堆的尾部添加元素
 *      offer()中实现上移(up) 操作来实现小顶堆的规则
 */
public class MinHeap {

    private int[] array;
    private int size;

    public MinHeap(int capacity) {
        array = new int[capacity];
    }

    //构造方法,将传来的数组以小顶堆的方式进行建堆
    public MinHeap(int[] array) {
        this.array = array;
        this.size = array.length;
        //建堆
        heapify();
    }

    private void heapify() {
/*        步骤:1.找到最后一个非叶子节点
        2.从后向前，对每个节点执行下潜*/
        int n = ( size / 2 ) - 1;   //找到最后一个非叶子节点
        for (int i = n; i >=0 ; i--) {
            down(i);
        }
    }

    private void down(int parent) {
        int left = parent * 2 + 1;
        int right = left + 1;
        int min = parent;
        if (left < size && array[left] < array[min]) {
            min = left;
        }
        if (right < size && array[right] < array[min]) {
            min = right;
        }
        if (min != parent) {
            swap(min,parent);
            down(min);
        }
    }
    //交换
    private void swap(int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    /**
     * 获取堆顶元素
     *
     * @return 堆顶元素
     */
    public Integer peek() {
        if (size == 0) {
            return null;
        }else {
            return array[0];
        }
    }

    /**
     * 删除堆顶元素
     *
     * @return 堆顶元素
     */
    public int poll() {
        int top = array[0];
        swap(0,size - 1);
        //先进行size--,然后再下潜
        size--;
        down(0);
        return top;
    }

    /**
     * 删除指定索引处元素
     *
     * @param index 索引
     * @return 被删除元素
     */
    public int poll(int index) {
        int deleted = array[index];
        swap(index, size - 1);
        size--;
        down(index);
        return deleted;
    }

    /**
     * 替换堆顶元素
     *
     * @param replaced 新元素
     */
    public void replace(int replaced) {
        array[0] = replaced;
        down(0);
    }

    /**
     * 堆的尾部添加元素
     *
     * @param offered 新元素
     */
    public boolean offer(int offered) {
        if (size == array.length) {
            return false;
        }
        up(offered);
        size++;
        return true;
    }
    private void up(int offered) {
        int child = size;
        while (child > 0) {
            int parent = (child - 1) / 2;
            if (offered < array[parent]) {
                array[child] = array[parent];
            } else {
                break;
            }
            child = parent;
        }
        array[child] = offered;
    }

    public static void main(String[] args) {
        int[] arr = {4,3,6,4,3,7,43,8};
        MinHeap minHeap = new MinHeap(arr);
        System.out.println(Arrays.toString(minHeap.array));
    }
}
