package LeetCode.src.main.java.leetcode;

import org.junit.Test;

import java.util.Arrays;
//合并两个有序数组
public class merge {
    @Test
    public void text() {
        int[] nums1 = {1,2,5,7,0,0,0,0};
        int[] nums2 = {2,3,4,6};
        merge1(nums1,4,nums2,4);
        merge2(nums1,4,nums2,4);
        merge3(nums1,4,nums2,4);
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        //将nums2数组的元素之间接入到nums1中，然后进行排序
        for (int i = 0; i != n; ++i) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        //双指针
        int p1 = 0, p2 = 0;
        int[] sored = new int[m+n];
        int cur;
        while (p1<m || p2< n) {
            if(p1 == m) cur = nums2[p2++];
            else if(p2 == n) cur = nums1[p1++];
            else if(nums1[p1] < nums2[p2]) cur = nums1[p1++];
            else cur = nums2[p2++];
            sored[p1 + p2 -1] = cur;
        }
        for (int i = 0; i != n + m; i++) {
            nums1[i] = sored[i];
        }
    }

//    逆向双指针
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        //两个指针p1,p2,分别指向nums1、nums2中最后一个元素
        int p1 = m -1;
        int p2 = n -1;
        //len指针指向nums1最后
        int len = m + n -1;
        //进行比较，将较大的元素的置于最后，直到p1或p2<0;
        while (p1>=0 && p2>=0){
            if(nums1[p1] >= nums2[p2]) {
                nums1[len--] = nums1[p1--];
            }else {
                nums1[len--] = nums2[p2--];
            }
        }
        while (p2>=0){
            nums1[len--] = nums2[p2--];
        }
    }
}
