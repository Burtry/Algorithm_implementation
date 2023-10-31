package LeetCode.src.main.java.Text_algorithm;
public class searchInsert {
    public int searchInsert1(int[] nums, int target) {
/*        给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。*/
        int left = 0, right = nums.length;
        while (left<right) {
            int middle = (right + left) >>1;
            if(target < nums[middle]) {
                right = middle;
            } else if (nums[middle] < target) {
                left = middle + 1;
            }else{
                return middle;
            }
        }
        //返回插入位置
        return  left;
    }
}
