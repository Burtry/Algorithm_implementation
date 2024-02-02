package JavaAlgo.src.main.java.datastructure.heap;

import java.util.Arrays;

//将传进来的数组以小顶堆进行堆排序
public class HeapSort {

    private static void sort(int[] arr) {
        int size = arr.length;
        //建堆
        heapify(arr,size);
        //排序
        while (size > 1) {
            swap(arr,0,size - 1);
            size --;
            // 重新调整堆
            down(arr, 0, size);
        }
    }

    //建堆
    private static void heapify(int[] arr, int size) {
        for (int i = (size / 2) - 1; i >= 0; i--) {
            down(arr,i,size);
        }
    }

    //下潜
    private static void down(int[] arr, int parent,int size) {
        int left = 2 * parent + 1;
        int right = left + 1;
        int max = parent;
        if (left < size && arr[left] > arr[max]) {
            max = left;
        }
        if (right < size && arr[right] > arr[max]) {
            max = right;
        }
        if (max != parent) {
            swap(arr,max,parent);
            //继续下潜
            down(arr,max,size);
        }
    }

    //交换
    private static void swap(int[]arr,int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {2,3,1,7,6,4,5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
