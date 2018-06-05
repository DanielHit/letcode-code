import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Daniel
 * @date 29/05/2018
 * <p>
 * 题目: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinations {


    private static HashMap<String, List<String>> hashMap = new HashMap<>();

    private static String d[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}, s = "";

    public static void main(String[] args) {
        System.out.println(letterCombinations(""));
        System.out.println(letterCombinations("234"));
        System.out.println("12".substring(1, 2));
    }


    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0 || digits == null) {
            return new ArrayList<>();
        }


        List<String> list = new ArrayList<>();
        if (digits.length() == 1) {
            String number = String.valueOf(digits.charAt(0));

            String temp = d[Integer.parseInt(number)];
            for (int i = 0; i < temp.length(); i++) {
                list.add(String.valueOf(temp.charAt(i)));
            }

            return list;

        }

        List<String> subList = letterCombinations(digits.substring(1, digits.length()));

        String temp = d[Integer.parseInt(String.valueOf(digits.charAt(0)))];

        for (int i = 0; i < temp.length(); i++) {
            for (int j = 0; j < subList.size(); j++) {
                list.add(temp.charAt(i) + subList.get(j));
            }
        }

        return list;


    }


}
