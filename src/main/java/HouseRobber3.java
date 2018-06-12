/**
 * @author Daniel
 * @date 12/06/2018
 */
public class HouseRobber3 {

    public static void main(String[] args) {

    }

    public int rob(TreeNode root) {

        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return root.val;
        }

        if (root.left == null && root.right != null) {
            return Math.max(root.val + rob(root.right.right) + rob(root.right.left), rob(root.right));
        }

        if (root.left != null && root.right == null) {
            return Math.max(root.val + rob(root.left.right) + rob(root.left.left), rob(root.left));
        }

        return Math.max(root.val + rob(root.left.right) + rob(root.left.left) + rob(root.right.left) + rob(root.right.right), rob(root.right) + rob(root.left));
    }
}
