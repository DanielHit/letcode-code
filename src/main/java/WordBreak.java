import java.util.ArrayList;
import java.util.List;

/**
 * @author Daniel
 * @date 25/05/2018
 */
public class WordBreak {
    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("car");
        wordDict.add("ca");
        wordDict.add("rs");
        String s = "cars";

        System.out.println(wordBreak(s, wordDict));
    }

    // word分词
    public static boolean wordBreak(String s, List<String> wordDict) {

        for (int i = 0; i < wordDict.size(); i++) {

            if (s.equals(wordDict.get(i))) {
                return true;

            } else if (s.contains(wordDict.get(i))) {

                String left = s.substring(0, s.indexOf(wordDict.get(i)));

                String right = s.substring(s.indexOf(wordDict.get(i)) + wordDict.get(i).length(), s.length());

                if (left.equals("") && wordBreak(right, wordDict) == true) {
                    return true;
                }

                if (right.equals("") && wordBreak(left, wordDict) == true) {
                    return true;
                }

                if (wordBreak(left, wordDict) == true && wordBreak(right, wordDict) == true) {
                    return true;
                }

            }

        }

        return false;
    }

}
