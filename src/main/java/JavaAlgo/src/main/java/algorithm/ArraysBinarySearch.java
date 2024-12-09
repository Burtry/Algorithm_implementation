package JavaAlgo.src.main.java.algorithm;

public class ArraysBinarySearch {

    private static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int mid = (low + high) >>> 1;
            int midVal = arr[mid];

            if (midVal < key) {
                low = mid + 1;
            } else if(midVal > key) {
                high = mid - 1;
            } else {
                return mid; //找到 key ,返回对应下标
            }
        }
        return -1; //没找到
    }


    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 6, 7, 8};
        int i = binarySearch(ints, 4);
        System.out.println(i);
    }
}
