package JavaAlgo.src.main.java.recursion;

import java.util.Arrays;

/**
 * 递归实现斐波那契数列
 * 优化-> 记忆法
 */
public class FibonacciMemory {

    /**
     *
     * @param n 第n项
     * @return 第n项的值
     */
    public static int fibonacci(int n) {
        int[] cache = new int[n + 1];
        //初始化数组为-1
        Arrays.fill(cache,-1);
        cache[0] = 0;
        cache[1] = 1;


        return  fun(n, cache);
    }

    public static int fun(int n, int[] cache) {

        if (cache[n] != -1) {
            return cache[n];
        }

        int x = fun(n - 1, cache);
        int y = fun(n - 2, cache);
        int sum = x + y;
        cache[n] = sum;
        return cache[n];
    }
}
