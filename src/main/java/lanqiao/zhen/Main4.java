package lanqiao.zhen;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class Main4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        int diff=0;
        int one=0;
        Map<Integer,Integer> hash=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            int num =scan.nextInt();
            hash.put(num,hash.getOrDefault(num,0)+1);
        }
        for (int value : hash.values()) {
            if (value > 2) {
                diff +=value - 2;
            } else if (value == 1) {
                one++;
            }
        }
        if (diff > one) {
            System.out.println(diff);
        } else {
            System.out.println(diff + (one - diff) / 2);
        }

        scan.close();
    }
}