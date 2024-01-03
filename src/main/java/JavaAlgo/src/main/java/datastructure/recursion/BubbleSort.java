package JavaAlgo.src.main.java.datastructure.recursion;

/**
 * 递归冒泡排序
 * 将数组划分成两部分[0...j] [j+1.....a.length-1]
 * 左边[0j]是未排序部分
 * 右边j+1.a.length-1]是已排序部分
 * 未排序区间内，相邻的两个元素比较，如果前一个大于后一个，则交换位置
 */
public class BubbleSort {

    public static void sort(int[] arr) {
        fun(arr, arr.length - 1);

    }


    /**
     * 冒泡排序的交换逻辑
     * @param arr 待排序的数组
     * @param j 未排序的右边界
     */
    private static void fun(int[] arr, int j) {

        //递归结束条件
        if (j == 0) {
            return;
        }

        int x =0;   //x作为标记，当执行到最后一次交换后，x后是有序的，x前无序。减少递归次数。

        for (int i = 0; i < j; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
                //一旦发生叫喊将i的值赋值给x
                x = i;
            }
        }
        //递归调用
        fun(arr, x);
    }

}
