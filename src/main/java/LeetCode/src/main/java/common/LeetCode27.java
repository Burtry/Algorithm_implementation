package LeetCode.src.main.java.common;

public class LeetCode27 {
    /**
     *  思路：设置一个变量记录当前不相同的指针，然后遍历，将不相同的元素设置到不相同的指针处然后++;
     */
    public int removeElement(int[] nums, int val) {
        int p1 = 0;
        for (int num : nums) {
            if (num == val) {
                continue;
            }
            nums[p1] = num;
            p1++;
        }
        return p1;
    }
}
