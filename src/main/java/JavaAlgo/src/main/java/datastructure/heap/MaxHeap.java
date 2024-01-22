package JavaAlgo.src.main.java.datastructure.heap;

public class MaxHeap {
    private int[] array;
    private int size;

    //初始化堆
    public MaxHeap(int capacity) {
        this.array = new int[capacity];
    }

    //建堆
    private void heapify() {
        /*
          步骤:1.找到最后一个非叶子节点
              2.从后向前，对每个节点执行下潜
         */
        int n = ( size / 2 ) - 1;   //找到最后一个非叶子节点
        for (int i = n; i >=0 ; i--) {
            down(i);
        }
    }

    // 将 parent 索引处的元素下潜: 与两个孩子较大者交换, 直至没孩子或孩子没它大
    private void down(int parent) {

    }

    // 交换两个索引处的元素
    private void swap(int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
}
