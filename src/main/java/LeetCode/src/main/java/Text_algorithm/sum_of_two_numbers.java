package LeetCode.src.main.java.Text_algorithm;

import java.util.HashMap;
import java.util.Map;

public class sum_of_two_numbers {
//    解法一
      public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i +1; j < nums.length; ++j) {
                if(nums[i] + nums[j] == target) {
                    return new int[] {i,j};
                }
            }
        }
        return new int[0];
    }
//    解法二：哈希表
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> hashable2 = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if(hashable2.containsKey(target - nums[i])) {
                return new int[] {i, hashable2.get(target - nums[i])};
            }
            hashable2.put(nums[i],i); // 将键值对加入到哈希表中
        }
        return new int[0];
    }

}
