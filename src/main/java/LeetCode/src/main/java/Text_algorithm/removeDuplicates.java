package LeetCode.src.main.java.Text_algorithm;
import org.junit.Test;

//删除有序数组中的重复项
public class removeDuplicates {
    @Test
    public  void text() {
        int[] nums = new int[] {1,1,3,4,5,6}; // 输入数组
        int[] expectedNums = new int[] {1,3,4,5,6}; // 长度正确的期望答案
        int k = removeDuplicates1(nums); // 调用

        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }
    }
    public int removeDuplicates1(int[] nums) {
        if(nums == null) return 0;
        int fast = 1;
        int slow = 1;
        while (fast < nums.length) {
            if(nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

}
