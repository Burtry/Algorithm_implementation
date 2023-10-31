package LeetCode.src.main.java.Text_algorithm;

public class isPalindrome2 {
    public boolean isPalindrome(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch)) {
                stringBuffer.append(Character.toLowerCase(ch));
            }
        }
        StringBuffer stringBuffer_rev = new StringBuffer(stringBuffer).reverse();
        return stringBuffer.toString().equals(stringBuffer_rev.toString());
    }
}
