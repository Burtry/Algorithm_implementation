package LeetCode.src.main.java.Text_algorithm.textAgain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class longestCommonPrefix {
    @Test
    public void text() {
        String[] strs= new String[]{"qwe", "qqq", "qw"};
//        System.out.println(strs[0]);
        String s = longestCommonPrefix1(strs);
//        System.out.println(s);
        assertEquals("q", s);
    }


    public String longestCommonPrefix1(String[] strs) {
        //将第一个字符串为公共前缀，与后面的字符串依次比较，如果没有公共字符串，
        //则公共字符串减一，继续进行比较，直到匹配到字符串或者没有公共字符串，返回s;
        String s = strs[0];
        for (String str : strs) {
            while (!str.startsWith(s)) {
                if (str.isEmpty()) return "";
                //公共字符串不匹配，进行减一
                s = s.substring(0, s.length() - 1);
            }
        }
        return s;
    }
}
