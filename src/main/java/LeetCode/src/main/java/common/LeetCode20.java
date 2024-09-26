package LeetCode.src.main.java.common;
import java.util.HashMap;
import java.util.Stack;

/**
 *有效的括号
 */
public class LeetCode20 {

    /**
     * 利用栈的特性进行求解
     * @param args
     */

    public static void main(String[] args) {
        String test = "{{{}}}";
        System.out.println(isValid(test));
    }


    public static boolean isValid(String s) {
        //创建映射
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        //创建栈
        Stack<Character> stack = new Stack<>();

        char[] charArray = s.toCharArray();

        if (charArray.length % 2 != 0) {
            return false;
        }
        for (char c : charArray) {
            if (map.containsKey(c)) {
                //左括号
                stack.push(c);
            } else{
                //右括号
                if (stack.isEmpty()) { //判断stack是否为空，为空的话返回false
                    return false;
                }
                Character pop = stack.pop(); //弹出来的一定是左括号的一种
                if (map.get(pop) != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }






    //public static boolean isValid(String s) {
    //    //创建映射
    //    HashMap<Character, Character> map = new HashMap<>();
    //    map.put('(',')');
    //    map.put('[',']');
    //    map.put('{','}');
    //    //创建存储栈
    //    Stack<Character> stack = new Stack<>();
    //    //将字符串转成字符数组
    //    char[] charArray = s.toCharArray();
    //    //
    //    if (charArray.length % 2 != 0) {
    //        return false;
    //    }
    //    //遍历字符数组
    //    for (Character c : charArray) {
    //        if (map.containsKey(c)) {
    //            //包含这个key ，左括号压入栈
    //            stack.push(c);
    //        } else {
    //            // 判断栈是否为空
    //            if (stack.isEmpty()) {
    //                return false;
    //            }
    //            if (map.get(stack.pop()) != c) {
    //                return false;
    //            }
    //        }
    //    }
    //    return stack.isEmpty();
    //
    //}












    //public static boolean isValid(String s) {
    //
    //    HashMap<Character, Character> characterHashMap = new HashMap<>();
    //    characterHashMap.put(']', '[');
    //    characterHashMap.put(')', '(');
    //    characterHashMap.put('}', '{');
    //
    //    Stack<Character> stack = new Stack<>();
    //    char[] charArray = s.toCharArray();
    //
    //    for (int i = 0; i < charArray.length; i++) {
    //        if (characterHashMap.containsKey(charArray[i])) {
    //            stack.push(charArray[i]);
    //        } else {
    //            char topElement = stack.isEmpty() ? '#': stack.pop();
    //            if (topElement != characterHashMap.get(charArray[i])) {
    //                return false;
    //            }
    //        }
    //    }
    //    return stack.isEmpty();
    //}














    //public static boolean isValid(String s) {
    //    HashMap<Character, Character> characterCharacterHashMap = new HashMap<>();
    //    characterCharacterHashMap.put('}','{');
    //    characterCharacterHashMap.put(')','(');
    //    characterCharacterHashMap.put(']','[');
    //
    //    Stack<Character> stack = new Stack<>();
    //    char[] chars = s.toCharArray();
    //
    //    if (chars.length % 2 != 0) {
    //        return false;
    //    }
    //
    //    for (int i = 0; i < chars.length; i++) {
    //        if (characterCharacterHashMap.containsKey(chars[i])) {
    //            char topEl = stack.empty() ? '#' : stack.pop();
    //            if (topEl != characterCharacterHashMap.get(chars[i])) {
    //                return false;
    //            }
    //        } else {
    //            stack.push(chars[i]);
    //        }
    //    }
    //    return stack.isEmpty();
    //}



}
