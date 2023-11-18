package JavaAlgo.src.main.java.recursion;

/**
 * 递归反向打印字符串
 */
public class ReversePrintString {

    public static void fun(int n,String str) {
        if(n == str.length()) {
            return;
        }
        fun(n+1,str);
        System.out.print(str.charAt(n));
    }

    public static void main(String[] args) {
        String str = "abcd";
        fun(0,str);
    }
}
