package lanqiao.zhen;

import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class Main1 {
    public static void main(String[] args) {
        int sum = 1000000;
        int a1 = 1;
        int a2 = 7;
        int a3 = 49;
        int a4 = 343;
        int a5 = 343 * 7;
        int a6 = 343 * 49;
        int a7 = 343 * 343;
        int a8 = a7 * 7;
        int a9 = a8 * 7;
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 5; j++) {
                for (int k = 0; k <= 5; k++) {
                    for (int l = 0; l <= 5; l++) {
                        for (int m = 0; m <= 5; m++) {
                            for (int n = 0; n <= 5; n++) {
                                for (int o = 0; o <= 5; o++) {
                                    for (int p = 0; p <= 5; p++) {
                                        for (int q = 0; q <= 5; q++) {
                                            if (i * a1 + j * a2 + k * a3 + l * a4 + m * a5 + n * a6 + o * a7 + p * a8
                                                    + q * a9 == sum) {

                                                System.out.println(i + j + k + l + m + n + o + p);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}