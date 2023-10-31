package LeetCode.src.main.java.Text_algorithm;

public class removeElement {
    //通解
    public int removeElement1(int[] nums, int val) {
        int idx = 0;    //指向插入位置
        for (int x : nums) {
            if(x != val) nums [idx ++] = x;
        }
        return idx;
    }


    //双指针
    public int removeElement2(int[] nums, int val) {
        int left = 0;   //指向下一个要赋值的位置
        //  int right = 0; 当前要处理的元素
        for (int right = 0; right < nums.length; right++) {
            if(nums[right] != val){
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }
}
