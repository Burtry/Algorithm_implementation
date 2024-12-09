package lanqiao.zhen;

import java.util.Scanner;

public class Main6 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            String str = scan.next();   //输入的每个字符串S
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                if(ch!='l'&&ch!='q'&&ch!='b'){
                    temp.append(ch);
                }
            }
            boolean flag = true;
            String s = temp.toString();
            String reverseS = temp.reverse().toString();
            if (!s.equals(reverseS)) {
                flag = false;
            }

            System.out.println(flag?"Yes":"No");
        }



    }







    //public static void main(String[] args) {
    //    Scanner sc = new Scanner(System.in);
    //
    //    int n = Integer.parseInt(sc.nextLine());
    //
    //    HashSet<Character> characters = new HashSet<>();
    //    characters.add('l');
    //    characters.add('q');
    //    characters.add('b');
    //
    //    StringBuffer[] arr = new StringBuffer[n];
    //    for (int i = 0; i < n; i++) {
    //        arr[i] = new StringBuffer(sc.nextLine());
    //    }
    //
    //
    //
    //
    //    for (int i = 0; i < arr.length; i++) {
    //        StringBuffer s = arr[i];
    //        if (reserveIsEq(s)) {
    //            System.out.println("Yes");
    //            return;
    //        }
    //        //需要添加字符的情况
    //        for (int j = 0; j < s.length(); j++) {
    //
    //            String strS = s.toString();
    //            // a b a c l
    //            int pre = 0;
    //            int pos = s.length() - 1;
    //
    //            if (!characters.contains(s.charAt(pos))) {
    //                System.out.println("No");
    //                return;
    //            } else {
    //                strS = String.valueOf(s.charAt(pos)) + s;
    //                reserveIsEq(new StringBuffer(strS));
    //            }
    //
    //        }
    //    }
    //}
    //
    //public static boolean reserveIsEq(StringBuffer s) {
    //    if (s.toString().equals(s.reverse().toString())) {
    //        s.reverse();
    //        return true;
    //    } else {
    //        s.reverse();
    //        return false;
    //    }
    //}

}
