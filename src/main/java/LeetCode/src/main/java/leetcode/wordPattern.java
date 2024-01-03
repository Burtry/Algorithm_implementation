package LeetCode.src.main.java.leetcode;

import org.junit.Test;

import java.util.HashMap;

public class wordPattern {
    public boolean wordPattern1(String pattern, String s) {
        String[] values = s.split(" ");
        if(values.length != pattern.length()) return false;
        //用来将字符映射到字符串
        HashMap<Character ,String> map = new HashMap<>();
        //用来将字符串映射到字符。这样可以确保字符和字符串之间的映射是一一对应的
        HashMap<String, Character> stringToCharMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char key = pattern.charAt(i);
            String value = values[i];
            //首先判读是否包含这个键，不包含的话，将此键和其所对应的value添加到哈希表中
            if(!map.containsKey(key) && !stringToCharMap.containsKey(value)) {
                map.put(key,value);
                stringToCharMap.put(value,key);
            }else {
                if(!map.containsKey(key) || !stringToCharMap.containsKey(value)) {
                    // 有一方包含了该键或值，但另一方没有，返回false
                    return false;
                }
                if(!map.get(key).equals(value) || stringToCharMap.get(value) != key) {
                    // 键值映射不匹配，返回false
                    return false;
                }
            }

        }
        return true;

        //存在的问题：当键b不存在时，而键a存在且a中的value与b中的value相同，出现bug.(已解决)
        /**
         *           a
         * values [ dog , dog , dog , dog ]
         */
        // key:     a      b
        // value:  dog    cat
        //
    }

    @Test
    public void text() {
        String pattern = "abba";
        String s = "dog dog dog dog";
        System.out.println(wordPattern1(pattern, s));
    }
}
