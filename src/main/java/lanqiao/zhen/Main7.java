package lanqiao.zhen;

import java.util.*;
public class Main7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];


        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int min = 0;
            int mid = arr.length / 2;

        for (int i = 0; i < mid; i++) {
            int Lsum = 0;
            int Rsum = 0;
            for (int j = 0; j < mid; j++) {
                Lsum = Lsum + arr[j];
            }

            for (int j = mid; j <n; j++) {
                Rsum = Rsum + arr[j];
            }
            int res = Rsum - Lsum;

            if (res < 0) {
                mid --;
            } else {
                mid ++;
                min = res;
            }
        }
        System.out.println(min);

    }
}
