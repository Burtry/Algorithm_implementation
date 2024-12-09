package lanqiao.commom;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// 1:无需package
// 2: 类名必须Main, 不可修改

public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashMap<Character, Integer> map = new HashMap<>();
        String s = scan.nextLine();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c,map.get(c) + 1);
            }
        }

        int max = Integer.MIN_VALUE;
        char key = ' ';
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                key = entry.getKey();
            }
        }

        System.out.println(key);
        System.out.println(max);


        scan.close();
    }
}