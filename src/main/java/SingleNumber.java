import java.util.HashMap;

/**
 * @author Daniel
 * @date 25/05/2018
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] num = new int[]{4, 1, 2, 1, 2};
        System.out.println(singleNumber(num));
    }


    // 使用了辅助的hashmap进行求解
    public static int singleNumber(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                hashMap.remove(nums[i]);
            } else {
                hashMap.put(nums[i], 1);
            }
        }


        return hashMap.keySet().iterator().next();

    }



}
