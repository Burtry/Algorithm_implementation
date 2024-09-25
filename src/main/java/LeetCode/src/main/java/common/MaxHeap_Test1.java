package LeetCode.src.main.java.common;

import java.util.Arrays;

public class MaxHeap_Test1 {
    //存储堆的数据
    private final int[] heap;
    private final int size;

    public MaxHeap_Test1(int[] array) {
        this.heap = array;
        this.size = heap.length;
        buildHeap();
    }

    //交换数组中的元素
    private void swap(int a, int b) {
        int tmp = heap[a];
        heap[a] = heap[b];
        heap[b] = tmp;
    }

    //获取非叶子结点的左子节点的索引
    private int left(int i) {
        return i * 2 + 1;
    }
    //获取非叶子结点的右子节点的索引
    private int right(int i) {
        return i * 2 + 2;
    }

    private void buildHeap() {
        //找到最后一个非叶子结点，然后向上遍历到根节点
        for (int i = (size /2) - 1; i >=0 ; i--) {
            heapify(i);
        }
    }

    private void heapify(int i) {
        //获得对应节点的下标
        int leftChild = left(i);
        int right = right(i);
        int largest = i;

        if (leftChild < size && heap[leftChild] > heap[largest]) {
            largest = leftChild;
        }

        if (right < size && heap[right] > heap[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(i,largest);
            heapify(largest);
        }
    }

    public static void main(String[] args) {
        int[] array = {3,19,1,14,8,7};

        MaxHeap_Test1 maxHeapTest1 = new MaxHeap_Test1(array);

        System.out.println(Arrays.toString(maxHeapTest1.heap));
    }
}
