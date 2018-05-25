import java.util.ArrayList;
import java.util.List;

/**
 * @author Daniel
 * @date 25/05/2018
 */
public class SymmetricTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(9);

        root.left.left = new TreeNode(15);
        root.right.right = new TreeNode(15);
        System.out.println(isSymmetric(root));

    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        List<TreeNode> list = new ArrayList<>();
        list.add(root.left);
        list.add(root.right);

        while (!isAllNullList(list)) {

            if (!isDuichengList(list)) {
                return false;
            }

            List<TreeNode> newList = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) != null) {
                    newList.add(list.get(i).left);
                    newList.add(list.get(i).right);
                } else {
                    newList.add(null);
                    newList.add(null);
                }
            }
            list = newList;
        }

        return true;

    }

    private static boolean isAllNullList(List<TreeNode> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                return false;
            }
        }
        return true;
    }

    private static boolean isDuichengList(List<TreeNode> list) {
        for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
            if (list.get(i) == null && list.get(j) == null) {
                continue;
            }

            if (list.get(i) != null && list.get(j) != null && list.get(i).val == list.get(j).val) {
                continue;
            }

            return false;
        }

        return true;
    }


}
