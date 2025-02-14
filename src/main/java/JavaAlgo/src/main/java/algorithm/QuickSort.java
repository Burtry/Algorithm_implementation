package JavaAlgo.src.main.java.algorithm;
/**
 * <h3>单边循环快排（lomuto 洛穆托分区方案）</h3>
 * <p>核心思想：每轮找到一个基准点元素，把比它小的放到它左边，比它大的放到它右边，这称为分区</p>
 * <ol>
 * <li>选择最右元素作为基准点元素</li>
 * <li>j 找比基准点小的，i 找比基准点大的，一旦找到，二者进行交换</li>
 * <ul>
 * <li>交换时机：j 找到小的，且与 i 不相等</li>
 * <li>i 找到 >= 基准点元素后，不应自增</li>
 * </ul>
 * <li>最后基准点与 i 交换，i 即为基准点最终索引</li>
 * </ol>
 */

public class QuickSort {

    public static void sort(int[] arr) {
        quickSort(arr,0,arr.length - 1);
    }

    private static void quickSort(int[] arr, int left, int right) {

        if (left >= right) {
            return;
        }
        int p = partition(arr,left,right);

        quickSort(arr, left,p -1);
        quickSort(arr,p + 1,right);
    }

    private static int partition(int[] arr, int left, int right) {
        int pv = arr[right]; //基准点
        int i = left;
        int j = left;
        while (j < right) {
            if (arr[j] < pv) {
                if (i != j) {
                    swap(arr, i, j);
                }
                i++;
            }
            j++;
        }

        swap(arr,i,right);
        return  i;
    }

    private static  void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
