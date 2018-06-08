/**
 * @author Daniel
 * @date 07/06/2018
 */
public class PathSum {

    public static void main(String[] args) {

    }

    public static int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        if (root.val == sum) {
            return 1 + pathSum(root.left, sum) + pathSum(root.right, sum);
        }

        return pathSum(root.left, sum - root.val) + pathSum(root.right, sum - root.val);
    }
}
