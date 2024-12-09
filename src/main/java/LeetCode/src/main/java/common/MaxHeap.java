package LeetCode.src.main.java.common;

import java.util.Arrays;

/**
 * 最大堆，创建的是一个传入一个数组，然后转换成最大堆的形式,添加添加元素，删除最大元素等功能。
 */
public class MaxHeap {

    private final int[] heap;  //存储堆的数组
    private int size;   //堆的大小
    private int capacity;   //堆容量

    public MaxHeap(int[] array) {
        this.heap = new int[array.length * 2];
        this.size = array.length;
        this.capacity = heap.length;
        System.arraycopy(array,0,heap,0,array.length);
        buildHeap();
    }

    //交换
    private void swap(int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    //获取该父节点的左子节点的索引
    private int left(int i) {
        return i * 2 + 1;
    }

    //获取右子节点的下标
    private int right(int i) {
        return i * 2 + 2;
    }

    private int parent(int i) {
        return ( i - 1 ) / 2;
    }

    private void buildHeap() {
        //获取最后一个非叶子结点,然后循环到根节点
        for (int i = (size / 2) - 1; i >=0 ; i--) {
            heapify(i);

        }
    }
    private void heapify(int i) {
        //左节点下标
        int leftChild = left(i);
        //右节点下标
        int rightChild = right(i);

        int largest = i;

        //找出左右子节点中较大的节点
        //判断左右节点小于size，避免数组越界问题
        if (leftChild < size && heap[leftChild] > heap[largest]) {
            largest = leftChild;
        }
        if (rightChild < size && heap[rightChild] > heap[largest]) {
            largest = rightChild;
        }

        if (largest != i) {
            swap(i,largest);
            heapify(largest);
        }
    }

    public void insert(int value) {
        if (size == capacity) {
            throw new RuntimeException("堆已满");
        }

        heap[size] = value;
        int current = size;
        size++;

        //上浮操作
        while (current > 0 && heap[current] > heap[parent(current)]){
            //与父节点交换
            swap(current,parent(current));
            //让当前节点设为父节点的索引
            current = parent(current);
        }

    }


    public int delMax() {
        int max = heap[0];

        heap[0] = heap[size - 1];
        size--;
        heapify(0);

        return max;
    }


    public void heapSort() {
        //记录原始堆大小
        int originalSize = size;

        for (int i = size - 1; i >=0 ; i--) {
            swap(0,i);
            size --;
            heapify(0);
        }
        size = originalSize;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8};

        MaxHeap maxHeap = new MaxHeap(array);
        System.out.println(Arrays.toString(maxHeap.heap));
        maxHeap.insert(6);

        System.out.println(Arrays.toString(maxHeap.heap));

        int max = maxHeap.delMax();

        System.out.println("max: " + max);
        System.out.println(Arrays.toString(maxHeap.heap));

        System.out.println("堆排序后：");
        maxHeap.heapSort();
        for (int i = maxHeap.size; i < maxHeap.capacity ; i++) {
            maxHeap.heap[i] = 0;
        }
        System.out.println(Arrays.toString(maxHeap.heap));
        System.out.println(maxHeap.size);

    }
}
