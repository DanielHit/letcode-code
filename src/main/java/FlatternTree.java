/**
 * @author Daniel
 * @date 25/05/2018
 */
public class FlatternTree {

    public static void flatten(TreeNode root) {

        if (root == null) {
            return;
        }

        if (root.right != null) {
            flatten(root.right);
        }

        if (root.left != null) {
            flatten(root.left);
        }

        TreeNode p = root.right;
        root.right = root.left;
        root.left = null;

        while (root.right != null) {
            root = root.right;
        }

        root.right = p;

    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

