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

    // 将 offered 元素上浮: 直至 offered 小于父元素或到堆顶
    private void up(int offered, int index) {

    }



    // 交换两个索引处的元素
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
    public int peek() {
        return array[0];
    }

    /**
     * 删除堆顶元素
     *
     * @return 堆顶元素
     */
    public int poll() {
        return 0;
    }

    /**
     * 删除指定索引处元素
     *
     * @param index 索引
     * @return 被删除元素
     */
    public int poll(int index) {
        return 0;
    }

    /**
     * 替换堆顶元素
     *
     * @param replaced 新元素
     */
    public void replace(int replaced) {

    }

    /**
     * 堆的尾部添加元素
     *
     * @param offered 新元素
     */
    public void offer(int offered) {

    }
}
