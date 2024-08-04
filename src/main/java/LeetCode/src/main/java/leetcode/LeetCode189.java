package LeetCode.src.main.java.leetcode;

import java.util.Arrays;

public class LeetCode189 {

    /**
     * [1,2,3,4,5,6,7]
     * [7,1,2,3,4,5,6]
     * [6,7,1,2,3,4,5]
     * [5,6,7,1,2,3,4]
     */

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        //rotate(nums,3);
        //System.out.println(Arrays.toString(nums));

        System.out.println("------------");
        rotate2(nums,3);
    }

    public static void rotate(int[] nums, int k) {

        k = k % nums.length;
        //反转整个数组 [7,6,5,4,3,2,1]
        reserve(nums, 0, nums.length - 1);
        //反转前k的元素[5,6,7,4,3,2,1]
        reserve(nums,0,k - 1);
        //反转剩余元素[5,6,7,1,2,3,4]
        reserve(nums,k,nums.length - 1);
    }
    private static void reserve(int[] nums, int start,int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


    //当数组足够大时，执行时间会很长
    public static void rotate2(int[] nums, int k) {
        k = k % nums.length;
        for (int i = 0; i < k; i++) {
            //获取最后一个元素
            int end = nums[nums.length - 1];
            //右移所有元素
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = end;
        }
    }

}
