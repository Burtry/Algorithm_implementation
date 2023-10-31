package LeetCode.src.main.java.Text_algorithm;

public class hammingDistance {
    public int hammingDistance1(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
