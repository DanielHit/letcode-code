import java.util.TreeMap;

/**
 * @author Daniel
 * @date 05/06/2018
 * https://leetcode.com/problems/majority-element/description/
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1, 1, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        int size = nums.length;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>((o1, o2) -> o2.intValue() - o1.intValue());

        for (int i = 0; i < size; i++) {
            if (treeMap.containsKey(nums[i])) {
                treeMap.put(nums[i], treeMap.get(nums[i]) + 1);
            } else {
                treeMap.put(nums[i], 1);
            }

            if (treeMap.get(nums[i]) > size / 2) {
                return nums[i];
            }
        }

        return treeMap.firstKey();
    }
}
