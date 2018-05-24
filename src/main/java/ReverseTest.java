/**
 * @author Daniel
 * @date 22/05/2018
 */
public class ReverseTest {

    public static void main(String[] args) {

        String a = "abbabfe";
        System.out.println(longestPalindrome(a));
    }

    public static String longestPalindrome(String s) {

        int maxNum = 0;

        String maxStirng = "";

        for (int i = 0; i < s.length(); i++) {

            for (int j = i; j < i; j++) {

                if (isReverseString(s.substring(i, j))) {

                    if (s.substring(i, j).length() > maxNum) {
                        maxStirng = s.substring(i, j);
                    }

                }

            }

        }
        return maxStirng;
    }

    public static boolean isReverseString(String a) {

        for (int i = 0, j = a.length() - 1; i <= j; i++, j--) {
            if (a.charAt(i) != a.charAt(j)) {
                return false;
            }
        }

        return true;
    }
}

