package JavaAlgo.src.main.java.datastructure.recursion;

/**
 * 递归实现斐波那契数列
 *
 */

/**
 * 斐波那契数列的递归次数： 2* fun(n+1) -1
 */
public class Fibonacci {

    public static int fun(int n) {

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int x = fun(n - 1);
        int y = fun(n - 2);
        return x + y;
    }
    public static void main(String[] args) {
        System.out.println(fun(8));
    }

}
