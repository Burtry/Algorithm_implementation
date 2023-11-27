package JavaAlgo.src.main.java.recursion;

/**
 * 兔子问题
 */
public class RabbitProblem {
    public static int fun(int n) {

        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        int x = fun(n - 1);
        int y = fun(n - 2);
        return x + y;
    }
    public static void main(String[] args) {
        System.out.println(fun(6));
    }
}
