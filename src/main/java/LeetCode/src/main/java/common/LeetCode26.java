package LeetCode.src.main.java.common;

public class LeetCode26 {
    /**
     *双指针，因为是数组是有序的可以依次比较然后赋值，最后返回慢指针即可。
     */

    public int removeDuplicates(int[] nums) {
        int p1 = 1;
        int p2 = 1;
        while(p1 < nums.length){
            if(nums[p1] != nums[p1 - 1]){
                nums[p2] = nums[p1];
                p2++;
            }
            p1++;
        }
        return p2;
    }
}
