/**
 * @author Daniel
 * @date 25/05/2018
 */
public class TreeMax {

    public static int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));

    }

}
