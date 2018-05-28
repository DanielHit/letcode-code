/**
 * @author Daniel
 * @date 28/05/2018
 */
public class MaxSubArray {
    public static void main(String[] args) {

    }

    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            sum = Math.max(nums[i], nums[i] + sum);
            max = Math.max(sum, max);
        }

        return max;
    }

}
