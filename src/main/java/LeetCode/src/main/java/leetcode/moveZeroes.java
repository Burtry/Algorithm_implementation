package LeetCode.src.main.java.leetcode;

import org.junit.Test;

import java.util.Arrays;

public class moveZeroes {
    @Test
    public void text1() {
        int[] nums = new int[] {1,0,3,5,0,6,7,0};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
    //[ 1 , 3 , 6 , 0 , 0 ]
    //          p1
    //                      p2
    public void moveZeroes(int[] nums) {
        int n = nums.length,p1 = 0,p2 = 0;
        while (p2<n) {
            if(nums[p2] != 0) {
                swap(nums,p1,p2);
                p1++;
            }
            p2++;
        }
    }
    public void swap(int[] nums, int p1, int p2) {
        int tmp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = tmp;
    }
}
