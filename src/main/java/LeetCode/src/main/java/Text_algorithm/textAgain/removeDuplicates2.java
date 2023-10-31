package LeetCode.src.main.java.Text_algorithm.textAgain;

public class removeDuplicates2 {
    //「删除有序数组重复项」的通解 ---宫水三叶
    /*1.由于是保留 k 个相同数字，对于前 k 个数字，我们可以直接保留；
      2.对于后面的任意数字，能够保留的前提是：与当前写入的位置前面的第 k 个元素进行比较，
    不相同则保留；*/

    //p=5                            num
    //                         p
    //[ 1 , 1 , 2 , 3 , 3 , 4, 4 , 4 , 5 , 5 ,5 , 7 ]
    public int removeDuplicates(int[] nums) {
        return process(nums,2);
    }
    private int process(int[] nums, int k) {
        int p = 0;
        for (int num : nums) {
            if( p < k || nums[p - k] != num) nums[p++] = num;
        }
        return p;
    }
}
