package LeetCode.src.main.java.common;

/**
 * 合并两个有序数组
 */
public class LeetCode88 {

    /**
     * 思路：从后往前 依次比较，最后再将nums2剩下的添加到nums1的last上
     */

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //nums1最后一个元素
        int p = m - 1;
        //nums2最后一个元素
        int q = n - 1;

        //指向nums最后一个元素
        int last = n + m - 1;

        while (p >= 0 && q >= 0) {
            if (nums1[p] > nums2[q]) {
                nums1[last] = nums1[p];
                p--;
            } else {
                nums1[last] = nums2[q];
                q--;
            }
            last--;
        }
        while (q >= 0) {
            nums1[last] = nums2[q];
            last--;
            q--;
        }
    }



}
