package LeetCode.src.main.java.text.textAgain;

public class removeElement {
    public int removeElement1(int[] nums, int val) {
        int p1 = 0;
        int p2 = 0;
        /*for (int i = 0; i < nums.length; i++) {
            if(nums[p2] == val) {
                p2++;
            }
            else {
                nums[p1] = nums[p2];
                p1++;p2++;
            }
        }*/
        for (int i = 0; i < nums.length; i++) {
            if(nums[p2] !=val){
                nums[p1] = nums[p2];
                p1++;
            }
            p2++;
        }
        return p1;
    }
}
