import java.util.ArrayList;
import java.util.List;

/**
 * @author Daniel
 * @date 07/06/2018
 */
public class NumbersDisappeared {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDisappearedNumbers(nums));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != i + 1) {
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[nums[i] - 1] = temp;
                --i;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                list.add(i + 1);
            }
        }

        return list;
    }

}
