package LeetCode.src.main.java.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

import static org.junit.Assert.assertTrue;

public class isValid {
    @Test
    public void text() {
        assertTrue(isValid3("()"));
    }

        public static boolean isValid1(String s) {
            Stack<Character> stack = new Stack<>();
            char[] chars = s.toCharArray();

            for (char c : chars) {
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                } else if (c == ')' || c == '}' || c == ']') {
                    if (stack.isEmpty() || !isValidPair(stack.pop(), c)) {
                        return false;
                    }
                }
            }

            return stack.isEmpty();
        }

        private static boolean isValidPair(char left, char right) {
            return (left == '(' && right == ')') || (left == '{' && right == '}') || (left == '[' && right == ']');
        }

    public static boolean isValid2(String s) {
        //创建哈希表，建立一一对应的关系
        Map<Character, Character> map = new HashMap<>();
        map.put('[', ']');
        map.put('(', ')');
        map.put('{', '}');
        map.put('?', '?');
        if(s.length() % 2 != 0 || (!s.isEmpty() && !map.containsKey(s.charAt(0)))) return false;
        else {
            LinkedList<Character> stack = new LinkedList<>(){{add('?');}};
            for (char c : s.toCharArray()) {
                if(map.containsKey(c)) stack.addLast(c);
                else if (map.get(stack.removeLast())!= c) return false;
            }
            return stack.size() == 1;
        }
    }

    public static boolean isValid3(String s) {
        // 创建哈希表，建立一一对应的关系
        Map<Character, Character> map = new HashMap<>();
        map.put('[', ']');
        map.put('(', ')');
        map.put('{', '}');

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                // 如果栈为空或者栈顶元素与当前字符不匹配，返回false
                if (stack.isEmpty() || map.get(stack.pop()) != c) {
                    return false;
                }
            }
        }
        // 最后，如果栈为空，说明所有括号都匹配成功
        return stack.isEmpty();
    }

}

