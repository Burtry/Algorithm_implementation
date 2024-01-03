package LeetCode.src.main.java.leetcode;

public class intreverse {
    public int reverse1(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }

    public int reverse2(int x) {
        StringBuilder sb = new StringBuilder();
        sb.append(Math.abs(x));

        try {
            //将sb对象内容反转再转换成整数
            int result = Integer.parseInt(sb.reverse().toString());
            return x > 0 ? result : -result;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
