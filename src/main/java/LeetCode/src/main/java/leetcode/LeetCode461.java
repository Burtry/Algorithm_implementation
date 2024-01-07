package LeetCode.src.main.java.leetcode;

public class LeetCode461 {
    public int hammingDistance1(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
