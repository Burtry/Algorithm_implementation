package LeetCode.src.main.java.leetcode;

import java.util.Objects;

public class isPalindrome {
    public boolean isPalindrome(int x) {
        //第一种转字符串
        String i1 = x + "";
        //第二种转字符串
        String i2 = String.valueOf(x);
        return Objects.equals(reverse1(i1), i1);
    }
    public static String reverse1(String str) {
        if(str == null) {
            return null;
        }
        String result = "";
        for (int i = str.length() - 1; i >=0; i--) {
            result += str.charAt(i);
        }
        return  result;
    }

    public boolean isPalindrome2(int x) {
        int i = 0;
        String s = x + "";
        while( i < s.length()){
            if(s.charAt(i) == s.charAt(s.length() - 1 - (i++))) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }
    //不转字符串做法
    public boolean isPalindrome3(int x) {
        if(x < 0)
            return false;
        int cur = 0;
        int num = x;
        while(num != 0) {
            cur = cur * 10 + num % 10;
            num /= 10;
        }
        return cur == x;
    }

    public boolean isPalindrome4(int x) {
        // 负数不可能是回文数
        if (x < 0) {
            return false;
        }

        String str = String.valueOf(x);
        StringBuffer content = new StringBuffer(new StringBuffer(str)).reverse();

        return content.toString().equals(str);
    }

}




