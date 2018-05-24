import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Daniel
 * @date 24/05/2018
 */
public class Permutations {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 3};
        System.out.println(permuteUnique(nums));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {


        if (nums.length == 1) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> tempList = new ArrayList<>();
            tempList.add(nums[0]);
            result.add(tempList);
            return result;
        }

        if (nums.length >= 2) {

            List<List<Integer>> lists = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {

                List<Integer> integerList = toList(nums);
                Integer removeInt = integerList.remove(i);
                int[] partialNum = new int[nums.length - 1];
                for (int j = 0; j < partialNum.length; j++) {
                    partialNum[j] = integerList.get(j);
                }

                // 子序列
                List<List<Integer>> templists = (permuteUnique(partialNum));

                for (int j = 0; j < templists.size(); j++) {
                    templists.get(j).add(removeInt);
                }

                lists.addAll(templists);
            }

            HashMap<String, List<Integer>> hashMap = new HashMap<>();
            for (List<Integer> list : lists) {
                String key = Arrays.toString(list.toArray());

                if (!hashMap.containsKey(key)) {
                    hashMap.put(key, list);
                }
            }

            List<List<Integer>> resultList = new ArrayList<>();
            hashMap.keySet().forEach(key -> {
                resultList.add(hashMap.get(key));
            });

            return resultList;
        }


        return null;

    }

    private static List<Integer> toList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        return list;
    }

}
