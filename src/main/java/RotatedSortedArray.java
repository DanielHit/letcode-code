import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Daniel
 * @date 29/05/2018
 */
public class RotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 1};
        System.out.println(search(nums, 8));
    }

    public static int[] search(int[] nums, int target) {
        List<Integer> list = search(nums, target, 0, nums.length - 1);
        Collections.sort(list);
        if (list.isEmpty()){
            list.add(-1);
            list.add(-1);
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    public static List<Integer> search(int[] nums, int target, int left, int right) {

        List<Integer> list = new ArrayList<>();

        if (left > right) {
            return list;
        }

        int mid = (left + right) / 2;

        if (nums[mid] == target) {
            list.add(mid);
        }

        List<Integer> leftSearch = search(nums, target, left, mid - 1);
        List<Integer> rightSearch = search(nums, target, mid + 1, right);


        if (!rightSearch.isEmpty()) {
            list.addAll(rightSearch);
        }
        if (!leftSearch.isEmpty()) {
            list.addAll(leftSearch);
        }


        return list;
    }
}
