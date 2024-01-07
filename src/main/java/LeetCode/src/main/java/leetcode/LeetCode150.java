package LeetCode.src.main.java.leetcode;

import java.util.LinkedList;

/**
 * 逆波兰表达式求值
 */
public class LeetCode150 {



    public int evalRPN(String[] tokens) {

        LinkedList<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            switch (token) {
                case "+" -> {
                    Integer b = stack.pop();
                    Integer a = stack.pop();
                    stack.push(a + b);
                }
                case "-" -> {
                    Integer b = stack.pop();
                    Integer a = stack.pop();
                    stack.push(a - b);
                }
                case "*" -> {
                    Integer b = stack.pop();
                    Integer a = stack.pop();
                    stack.push(a * b);
                }
                case "/" -> {
                    Integer b = stack.pop();
                    Integer a = stack.pop();
                    stack.push(a / b);
                }
                default -> {
                    //转成数字
                    stack.push(Integer.parseInt(token));
                }
            }
        }

        return stack.pop();
    }

}
