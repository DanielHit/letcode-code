import java.util.ArrayList;
import java.util.List;

/**
 * @author Daniel
 * @date 28/05/2018
 */
public class Subset {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length == 0) {
            lists.add(new ArrayList<>());
            return lists;
        }

        if (nums.length == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            lists.add(list);
            lists.add(new ArrayList<>());
            return lists;
        }

        if (nums.length >= 2) {
            int lastInt = nums[nums.length - 1];

            List<List<Integer>> subList = subsets(getSubNum(nums));
            List<List<Integer>> newSubList = new ArrayList<>();

            for (int i = 0; i < subList.size(); i++) {
                List<Integer> temp = new ArrayList<>();
                temp.addAll(subList.get(i));
                temp.add(lastInt);
                newSubList.add(temp);
            }
            lists.addAll(subList);
            lists.addAll(newSubList);
        }

        return lists;
    }

    private static int[] getSubNum(int[] nums) {
        int[] subNum = new int[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            subNum[i] = nums[i];
        }
        return subNum;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(subsets(nums));
    }

}
