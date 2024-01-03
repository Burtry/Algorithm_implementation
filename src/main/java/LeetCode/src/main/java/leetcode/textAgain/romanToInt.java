package LeetCode.src.main.java.leetcode.textAgain;

import java.util.HashMap;
import java.util.Map;

public class romanToInt {
    public int romanToInt1(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num = getValue(s.charAt(i));
            if(preNum < num) sum -= preNum;
            else sum += preNum;
            preNum = num;
        }
        sum +=preNum;
        return sum;
    }

    private int getValue(char ch) {
        switch (ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

//哈希表
    public int romanToInt2(String s) {
        Map<Character,Integer> getValue = new HashMap<>();
        getValue.put('I', 1);
        getValue.put('V', 5);
        getValue.put('X', 10);
        getValue.put('L', 50);
        getValue.put('C', 100);
        getValue.put('D', 500);
        getValue.put('M', 1000);
        int sum = 0;
        int preNum = getValue.get(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int val = getValue.get(s.charAt(i));
            if(preNum < val) sum -= preNum;
            else sum += preNum;
            preNum = val;
        }
        sum += preNum;
        return sum;
    }
}
