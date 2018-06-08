import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Daniel
 * @date 07/06/2018
 */
public class Anagrams {

    public static void main(String[] args) {
        System.out.println(findAnagrams2("cbaebabacd", "abc"));
        System.out.println(findAnagrams2("abab", "ab"));
    }

    public List<Integer> findAnagrams3(String s, String p) {
        ArrayList<Integer> result = new ArrayList<>();
        if (s == null || p == null) {
            return result;
        }

        int left = 0, right = 0, count = p.length();
        int[] map = new int[256];
        char[] sc = s.toCharArray();

        for (char c : p.toCharArray()) {
            map[c]++;
        }

        while (right < s.length()) {
            if (map[sc[right++]]-- >= 1) {
                count--;
            }

            if (count == 0) {
                result.add(left);
            }

            if (right - left == p.length() && map[sc[left++]]++ >= 0) {
                count++;
            }
        }
        return result;
    }

    public static List<Integer> findAnagrams2(String s, String p) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (i + p.length() > s.length()) {
                return list;
            }
            if (isAnagram(s.substring(i, i + p.length()), p)) {
                list.add(i);
            }
        }

        return list;
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }

        if (s.length() == p.length()) {
            if (isAnagram(s, p)) {
                list.add(0);
                return list;
            }
        }

        List<Integer> subList = findAnagrams(s.substring(1, s.length()), p);
        if (isAnagram(s.substring(0, p.length()), p)) {
            list.add(0);
        }

        for (int i = 0; i < subList.size(); i++) {
            subList.set(i, subList.get(i) + 1);
        }

        list.addAll(subList);
        return list;

    }

    private static boolean isAnagram(String s, String p) {
        char[] sChar = s.toCharArray();
        char[] pChar = p.toCharArray();

        Arrays.sort(sChar);
        Arrays.sort(pChar);

        for (int i = 0; i < sChar.length; i++) {
            if (sChar[i] != pChar[i]) {
                return false;
            }
        }

        return true;
    }
}
