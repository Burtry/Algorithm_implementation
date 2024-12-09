package lanqiao.commom;

public class Main3 {
    public static void main(String[] args) {

        int num = 0;
        String s = "";
        for (int i = 1; i <= 2020; i++) {
            s = i + "";
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '2') {
                    num++;
                }
            }
        }
        System.out.println(num);
    }
}
