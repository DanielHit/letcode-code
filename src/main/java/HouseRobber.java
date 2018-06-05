/**
 * @author Daniel
 * @date 05/06/2018
 * <p>
 * https://leetcode.com/problems/house-robber/description/
 */
public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 9, 3, 1};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        return robI(nums, nums.length - 1);
    }

    public static int robI(int[] nums, int i) {

        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] temp = new int[i + 1];
        temp[0] = nums[0];
        temp[1] = Math.max(nums[0], nums[1]);

        for (int j = 2; j <= i; j++) {
            temp[j] = Math.max(temp[j - 1], temp[j - 2] + nums[j]);
        }


        return temp[i];
    }

}
