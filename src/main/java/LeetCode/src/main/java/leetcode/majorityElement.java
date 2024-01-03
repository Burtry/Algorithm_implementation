package LeetCode.src.main.java.leetcode;

import java.util.HashMap;
import java.util.Map;

public class majorityElement {

    //哈希表
    //键表示一个元素，值表示该元素出现的次数
    public int majorityElement1(int[] nums) {
//        IntStream sorted = Arrays.stream(nums).sorted();
        Map<Integer,Integer> counts = countNums(nums);
        Map.Entry<Integer,Integer> majorEntry = null;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : counts.entrySet()) {
            if (majorEntry == null || integerIntegerEntry.getValue() > majorEntry.getValue()) {
                majorEntry = integerIntegerEntry;
            }
        }
        return  majorEntry.getKey();
    }

    private Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            if(!counts.containsKey(num)) {
                counts.put(num,1);
            }else {
                counts.put(num,counts.get(num) + 1);
            }
        }
        return  counts;
    }

    //摩尔投票
    public int majorityElement2(int[] nums) {
        int x = 0, votes = 0;
        for (int num : nums){
            if (votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }


}
