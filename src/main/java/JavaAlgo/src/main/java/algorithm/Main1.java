package JavaAlgo.src.main.java.algorithm;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();

        for (int i = 0; i < num; i++) {
            long N = scan.nextLong();
            long M = scan.nextLong();
            long K = scan.nextLong();

            // 计算在长边和宽边上能放置的显示器数量

            long countN = N / K;
            long countM = M / K;


            long num1 = 0;

            long num2 = 0;
            if (countN > 2) {
                num1 = countN - 2;
            }
            if (countM > 2) {
                num2 = countM - 2;
            }

            long mid = num1 * num2;

            if (countN > 2 || countM > 2) {
                // 输出最多能放置的显示器数量
                System.out.println(countN * countM - mid);
            } else {
                System.out.println(countN * countM);
            }

        }
        //在此输入您的代码...
        scan.close();
    }
}
