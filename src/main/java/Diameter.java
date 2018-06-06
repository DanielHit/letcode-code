/**
 * @author Daniel
 * @date 06/06/2018
 */
public class Diameter {

    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 0;
        }

        if (root.left == null) {
            return Math.max(diameterOfBinaryTree(root.right), heiightOfTree(root) - 1);
        }

        if (root.right == null) {
            return Math.max(diameterOfBinaryTree(root.left), heiightOfTree(root) - 1);
        }

        int ineerPath = Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right));

        return Math.max(ineerPath, heiightOfTree(root.left) + heiightOfTree(root.right) - 2);
    }

    public static int heiightOfTree(TreeNode node) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return 1;
        }

        return Math.max(heiightOfTree(node.left), heiightOfTree(node.right)) + 1;

    }


}
