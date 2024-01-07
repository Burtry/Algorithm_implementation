package LeetCode.src.main.java.leetcode;

public class LeetCode28 {
    public int strStr1(String haystack, String needle) {
        //包含needle,找出在haystack中needle字符串的第一个匹配的下标
        char[] haystackCharArray = haystack.toCharArray();
        char[] needleCharArray = needle.toCharArray();
        int n = haystack.length();
        int m = needle.length();
        for (int i = 0; i <=n-m; i++) {
            int a = i, b = 0;
            while (b < m && haystackCharArray[a] == needleCharArray[b]) {
                a++;
                b++;
            }
            // 如果能够完全匹配，返回原串的「发起点」下标
            if (b == m) return i;
        }
        return -1;
    }
    public int strStr2(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
