package LeetCode.src.main.java.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class romanToInt {
    @Test
    public  void text() {
        System.out.println(romanToInt1("III"));
    }
    //解法一
    public int romanToInt1(String s) {
        int sum = 0;
        //取第一个元素
        int preNum = getValue(s.charAt(0));
        for(int i = 1;i < s.length(); i ++) {
            int num = getValue(s.charAt(i));
            //把一个小值放在大值的左边，就是做减法，否则为加法
            if(preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    //返回一一对应的数值
    private int getValue(char ch) {
        return switch (ch) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }
    //解法二，哈希表
    public int romanToInt2(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int ans = 0;
        for(int i = 0;i < s.length();) {
            if(i + 1 < s.length() && map.containsKey(s.substring(i, i+2))) {
                ans += map.get(s.substring(i, i+2));
                i += 2;
            } else {
                ans += map.get(s.substring(i, i+1));
                i ++;
            }
        }
        return ans;
    }
}


