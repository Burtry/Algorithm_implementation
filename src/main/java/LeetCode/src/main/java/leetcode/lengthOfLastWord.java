package LeetCode.src.main.java.leetcode;

import org.junit.Test;

public class lengthOfLastWord {
    @Test
    public void text() {
        String s = "luffy is still joyboy hrterg";
        String[] strarr = s.split(" ");
        String string = strarr[strarr.length - 1];
        System.out.println(string.length());
    }
    // 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
    public int lengthOfLastWord1(String s) {
        String[] strarr = s.split(" ");
    // 锁定最后一个数组元素
        int len = strarr.length - 1;
        String string = strarr[len].toString();
        return  string.length();
    }
}
