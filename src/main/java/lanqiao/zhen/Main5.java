package lanqiao.zhen;

import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (isGoodNum(i)) {
                res ++;
            }
        }

        System.out.println(res);
    }

    private static boolean isGoodNum(int i) {
        String s = String.valueOf(i);

        int now = 1; //当前位数
        for (int j = s.length() - 1; j >= 0; j--) {
            if (isJ(now)) {
                if (!isJ(s.charAt(j))) {
                    return false;
                }
            } else {
                if (isJ(s.charAt(j))) {
                    return false;
                }
            }
            now++;
        }
        return true;

    }

    private static boolean isJ(int num) {
        if (num % 2 == 0) {
            return false;
        } else {
            return true;
        }
    }
}
