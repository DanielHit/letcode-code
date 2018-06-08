/**
 * @author Daniel
 * @date 07/06/2018
 */
public class TargetSum {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 1, 1};
        System.out.println(findTargetSumWays(nums, 3));
    }


    public static int findTargetSumWays(int[] nums, int S) {

        if (nums.length == 1) {

            int count = 0;

            if (nums[0] + S == 0) {
                count++;
            }

            if (nums[0] - S == 0) {
                count++;
            }

            return count;
        }

        int[] subNums = new int[nums.length - 1];

        for (int i = 0; i < subNums.length; i++) {
            subNums[i] = nums[i + 1];
        }

        return findTargetSumWays(subNums, S + nums[0]) + findTargetSumWays(subNums, S - nums[0]);
    }
}
