package LeetCode.src.main.java.leetcode;

import org.junit.Test;

import java.util.Arrays;

public class LeetCode383 {


    @Test
    public void text() {
        canConstruct("aabbcc", "aabbccddd");
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        if(magazine.length() < ransomNote.length()) {
            return false;
        }
        int[] cnt = new int[26];
        for (char c : magazine.toCharArray()) {
            cnt[c - 'a']++;
        }
        System.out.println(Arrays.toString(cnt));
        for (char c : ransomNote.toCharArray()) {
            cnt[c - 'a']--;
            if(cnt[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

}
