import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Daniel
 * @date 12/06/2018
 */
public class FindDisappearNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDisappearedNumbers(nums));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i]) {
                list.add(i + 1);
            }
        }

        return list;
    }
}
