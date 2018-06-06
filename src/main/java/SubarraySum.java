/**
 * @author Daniel
 * @date 06/06/2018
 */
public class SubarraySum {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 1, 2};
        System.out.println(subarraySum(nums, 2));
    }

    public static int subarraySum(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            if (nums[0] == k) {
                return 1;
            } else {
                return 0;
            }
        }

        int count = 0;
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                count++;
            }
        }

        int[] subNum = new int[nums.length - 1];
        for (int i = 0; i < subNum.length; i++) {
            subNum[i] = nums[i + 1];
        }

        if (nums[0] == k) {
            return 1 + count + subarraySum(subNum, k);
        } else {
            return count + subarraySum(subNum, k);
        }
    }
}
