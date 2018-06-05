/**
 * @author Daniel
 * @date 05/06/2018
 */
public class InvertBinaryTree {
    public static void main(String[] args) {

    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }


        if (root.left != null) {
            root.left = invertTree(root.left);
        }

        if (root.right != null) {
            root.right = invertTree(root.right);
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}
