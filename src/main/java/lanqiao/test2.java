package lanqiao;

import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        String[] strArr = new String[q];
        for (int i = 0; i < q; i++) {
            strArr[i] = sc.next();
        }
        for (int i = 0; i < q; i++) {
            char[] arr = strArr[i].toCharArray();
            StringBuilder str1 = new StringBuilder();
            StringBuilder str2 = new StringBuilder();
            for(int j = 0; j <arr.length; j++) {
                int num = Integer.parseInt(String.valueOf(arr[j]));
                if(num % 2 == 0) {
                    str2.append(num);
                } else  {
                    str1.append(num);
                }
            }
            if(str2.isEmpty()) {
                System.out.println(-1);
                continue;
            }
            str1.append(str2);
            System.out.println(str1);
        }
    }
}
