package LeetCode.src.main.java.Text_algorithm.textAgain;

public class removeDuplicates {
    public int removeDuplicates(int[] nums) {
        //记录当前数组的长度
        int len = nums.length;
        int p1 = 1,p2 = 1;
        for (int i = 1; p2 < nums.length; i++) {
            //nums[ 1 , 1 , 2 , 3 , 3 , 4 ]

            //nums[ 1 , 2 , 3 , 4 , 3 , 4 ]
            //                      p1
            //                          p2
            if(nums[p2] == nums[p2 - 1]) {
                p2++;
            }
            else {
                nums[p1] = nums[p2];
                len--;
                p1++;p2++;
            }
        }
        return p1;
    }
}
