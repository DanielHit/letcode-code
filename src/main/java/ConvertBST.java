import java.util.ArrayList;
import java.util.List;

/**
 * @author Daniel
 * @date 07/06/2018
 */
public class ConvertBST {

    public static void main(String[] args) {

    }

    public TreeNode convertBST(TreeNode root) {

        // 后续遍历

        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }

        List<TreeNode> treeNodes = getTreeList(root);

        int sum = 0;
        for (int i = 0; i < treeNodes.size(); i++) {
            sum += treeNodes.get(i).val;
            treeNodes.get(i).val = sum;
        }

        return root;

    }


    // 中间
    public List<TreeNode> getTreeList(TreeNode root) {
        List<TreeNode> treeNodes = new ArrayList<>();
        if (root == null) {
            return treeNodes;
        }

        if (root.right == null && root.left == null) {
            treeNodes.add(root);
            return treeNodes;
        }

        treeNodes.addAll(getTreeList(root.right));
        treeNodes.add(root);
        treeNodes.addAll(getTreeList(root.left));

        return treeNodes;
    }
}

