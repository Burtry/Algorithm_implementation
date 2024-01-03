package LeetCode.src.main.java.leetcode;

public class hammingDistance {
    public int hammingDistance1(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
