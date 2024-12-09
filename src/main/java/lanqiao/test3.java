package lanqiao;
import java.util.*;
public class test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String happy = ":-)";
        String sad = ":-(";

        String str = sc.nextLine();

        int happyNum = check(str,happy);
        int sadNum = check(str,sad);

        if(happyNum == 0 && sadNum == 0) {
            System.out.println("None");
        } else if (happyNum > sadNum) {
            System.out.println("Happy");
        } else if (sadNum > happyNum) {
            System.out.println("Sad");
        } else  {
            System.out.println("Just so so");
        }

    }

    public static int check(String str, String subStr) {
        if(str.length() == 0) {
            return 0;
        }
        int count = 0;
        int index = 0;

        while ((index = str.indexOf(subStr,index)) != -1) {
            count++;
            index+=subStr.length();
        }

        return count;
    }
}
