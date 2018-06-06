/**
 * @author Daniel
 * @date 06/06/2018
 */
public class SubTree {
    public static void main(String[] args) {

    }

    public static boolean isSubtree(TreeNode s, TreeNode t) {

        if (s == null && t == null) {
            return true;
        }

        if (s == null && t != null) {
            return false;
        }

        if (isSame(s, t)) {
            return true;
        }

        if (s.left == null) {
            return isSubtree(s.right, t);
        }

        if (s.right == null) {
            return isSubtree(s.left, t);
        }

        return isSubtree(s.right, t) || isSubtree(s.left, t);
    }

    public static boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }

        if (s == null && t != null) {
            return false;
        }

        if (s != null && t == null) {
            return false;
        }

        return s.val == t.val && isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}
