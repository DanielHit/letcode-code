import java.util.*;

/**
 * @author Daniel
 * @date 23/05/2018
 */
public class GroupTest {
    public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};


        char[] str2char = input[1].toCharArray();
        Arrays.sort(str2char);
        System.out.println(String.valueOf(str2char));

        System.out.println(groupAnagrams(input));

    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> resultList = new ArrayList<>();

        HashMap<String, List<String>> hashMap = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {

            char[] str2char = strs[i].toCharArray();
            Arrays.sort(str2char);
            String key = String.valueOf(str2char);

            if (hashMap.containsKey(key)) {
                hashMap.get(key).add(strs[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                hashMap.put(key, list);
            }
        }

        // 打印

        System.out.println(hashMap);

        hashMap.keySet().forEach(key -> {
            resultList.add(hashMap.get(key));
            System.out.println(key);
        });

        // 高可用建设方面
        return resultList;
    }

}
