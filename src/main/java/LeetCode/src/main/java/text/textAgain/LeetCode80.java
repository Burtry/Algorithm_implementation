package LeetCode.src.main.java.text.textAgain;

public class LeetCode80 {
    public int removeDuplicates(int[] nums) {

        return process(nums,2);
    }
    int process(int[] nums, int k) {

        int p = 0;
        for (int num : nums) {
            if(p < k || nums[p - k] != num) nums[p++] = num;
        }
        return p;
    }
}
