/**
 * Created by Daniel on 18/5/29.
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        int[] temp = new int[]{1,3,5,6};
        System.out.println(searchInsert(temp, 5));
    }

    public static int searchInsert(int[] nums, int target) {
        return searchInsert(nums, target, 0, nums.length - 1);
    }

    public static int searchInsert(int[] nums, int target, int left, int right) {

        if (target <= nums[left]){
            return left;
        }

        if (target > nums[right]){
            return right + 1;
        }


        int mid = (left + right) /2;

        if (nums[mid] == target){
            return mid;
        }

        int leftValue = searchInsert(nums, target, left, mid -1);
        int rightValue  = searchInsert(nums, target, mid + 1, right);

        if (leftValue <= mid){
            return leftValue;
        }

        if (rightValue > right) {
            return rightValue;
        }

        return leftValue;

    }
}
