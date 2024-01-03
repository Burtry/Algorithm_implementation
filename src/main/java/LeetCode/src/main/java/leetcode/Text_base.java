package LeetCode.src.main.java.leetcode;

import java.util.Arrays;

public class Text_base {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int content = binarySearchBasic(arr, 4);
        int content1 = binarySearchBalance(arr, 1);
        System.out.println(content1);
        System.out.println(content);
        int[] arr2 = {1, 2, 5, 65, 7, 32};
//        BubbleSort(arr2);
        SelectSort(arr2);
    }

    //二分查找
    // 基础版
    public static int binarySearchBasic(int[] arr, int target) {
        int i = 0, j = arr.length - 1; // 设置指针初值
        while (i <= j) {
            int m = (i + j) >>> 1; // 中间值
            if (target < arr[m]) { // 在m的左边
                j = m - 1;
            } else if (arr[m] < target) { // 在m的右边
                i = m + 1;
            } else {
                return m;
            }

        }
        return -1;
    }

    //修改版
    public static int binarySearchAlternative(int[] arr, int target) {
        int i = 0, j = arr.length; // 第一处修改
        while (i < j) { // 第二次修改
            int m = (i + j) >>> 1;
            if (target < arr[m]) {
                j = m; // 第三处修改
            } else if (arr[m] < target) {
                i = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    //平衡版 (缩小范围，减少if次数)
    public static int binarySearchBalance(int[] arr, int target) {
        int i = 0, j = arr.length - 1; // 设置指针初值
        while (1 < j - i) {
            int m = (i + j) >>> 1; // 中间值
            if (target < arr[m]) {
                j = m;
            } else {
                i = m;
            }
        }
        if (target == arr[i])
            return i;
        else
            return -1;

    }

    //冒泡排序
    public static void BubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }

        }
        System.out.println(Arrays.toString(arr));
    }

    //选择排序
    public static void SelectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}

