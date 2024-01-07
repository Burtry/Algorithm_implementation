package LeetCode.src.main.java.leetcode;

public class LeetCode392 {
    public boolean isSubsequence1(String s, String t) {
        //双指针
        //s 为 t 的子序列
        // t
        //                    p1
        //  a  s  d  b  a  c  d

        // s
        //  a  b  c
        //           p2
        int p2 = 0;
        int len_t = s.length();
        if(s.isEmpty()) return true;
        for (int p1 = 0; p1 < t.length();p1++) {
            if(t.charAt(p1) == s.charAt(p2)) {
                p2++;
                if(len_t == p2) {
                    return true;
                }
            }
        }
        return false;
    }
}
