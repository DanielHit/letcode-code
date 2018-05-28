/**
 * @author Daniel
 * @date 26/05/2018
 */
public class ValidateBinarySearch {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(211);

        System.out.println(max(root));
        System.out.println(min(root));

        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {

        // null check
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        if (root.left == null && root.right != null) {
            return root.val < min(root.right) && isValidBST(root.right);
        }

        if (root.right == null && root.left != null) {
            return root.val > max(root.left) && isValidBST(root.left);
        }

        return root.val < min(root.right) && isValidBST(root.right) && root.val > max(root.left) && isValidBST(root.left);
    }

    public static int max(TreeNode root) {

        if (root.right == null && root.left == null) {
            return root.val;
        }

        if (root.left == null) {
            return Math.max(root.val, max(root.right));
        }

        if (root.right == null) {
            return Math.max(root.val, max(root.left));
        }

        if (root.left != null && root.right != null) {
            return Math.max(root.val, Math.max(max(root.left), max(root.right)));
        }

        return 0;
    }

    public static int min(TreeNode root) {

        if (root.right == null && root.left == null) {
            return root.val;
        }

        if (root.left == null) {
            return Math.min(root.val, min(root.right));
        }

        if (root.right == null) {
            return Math.min(root.val, min(root.left));
        }

        if (root.left != null && root.right != null) {
            return Math.min(root.val, Math.min(min(root.left), min(root.right)));
        }

        return 0;
    }

}
