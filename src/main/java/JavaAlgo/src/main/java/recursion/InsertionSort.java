package JavaAlgo.src.main.java.recursion;


/**
 * 递归实现插入排序
 */
public class InsertionSort {
    public static void sort(int[] arr) {
        insertion(arr,1);

    }

    public static void sort2(int[] arr) {
        insertion2(arr,1, arr.length - 1);
    }


    /**
     *
     * @param arr 待排序数组
     * @param low 未排序区域的下边界
     */
    private static void insertion(int[] arr, int low) {
        if(low == arr.length) {
            return;
        }

        int tmp = arr[low];
        int i = low -1; //已排序区域指针

        //找比tmp小的元素
        while (i >= 0 && arr[i] > tmp) {
            arr[i + 1] = arr[i];    //空出插入位置
            i--;
        }
        //找到了
        arr[i + 1] = tmp;

        insertion(arr, low +1);
    }

    private static void insertion2(int[] arr, int low, int high) {
        if(low == high) {
            return;
        }

        int tmp = arr[low];
        int i = low -1; //已排序区域指针

        //找比tmp小的元素
        while (i >= 0 && arr[i] > tmp) {
            arr[i + 1] = arr[i];    //空出插入位置
            i--;
        }
        //找到了
        arr[i + 1] = tmp;

        insertion2(arr, low +1, high);
    }

}
