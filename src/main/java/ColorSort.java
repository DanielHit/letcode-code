import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Daniel
 * @date 28/05/2018
 */
public class ColorSort {

    public static void main(String[] args) {
        int[] num = new int[]{2, 0, 2, 1, 1, 0};
        sortColors(num);
        Arrays.stream(num).forEach(p -> System.out.println(p));
    }

    public static void sortColors(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                hashMap.put(nums[i], hashMap.get(nums[i]) + 1);
            } else {
                hashMap.put(nums[i], 1);
            }
        }

        ArrayList<Integer> newNums = new ArrayList<>();

        hashMap.keySet().forEach(key -> {
            for (int i = 0; i < hashMap.get(key); i++) {
                newNums.add(key);
            }
        });

        for (int i = 0; i < newNums.size(); i++) {
            nums[i] = newNums.get(i);
        }
    }

}
