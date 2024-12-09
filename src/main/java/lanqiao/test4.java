package lanqiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] arr = new int[2];
            arr[0] = sc.nextInt();
            arr[1] = sc.nextInt();
            list.add(arr);
        }

        for (int i = 0; i < n / 2; i++) {
            int[] arr1 = list.get(i);
            //寻找权值最大
            for (int j = 0; j < list.size(); j++) {

            }

        }



        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(list.get(i)));
        }

    }
}
