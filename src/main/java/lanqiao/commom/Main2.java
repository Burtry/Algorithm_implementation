package lanqiao.commom;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int jige = 0;
        int youxiu = 0;

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (num >= 60) {
                jige++;
            }
            if (num >= 85) {
                youxiu++;
            }
        }

        System.out.println(Math.round((float)jige*100/n)+"%");
        System.out.println(Math.round((float)youxiu*100/n)+"%");

    }
}
