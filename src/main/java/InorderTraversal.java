import java.util.ArrayList;
import java.util.List;

/**
 * @author Daniel
 * @date 28/05/2018
 */
public class InorderTraversal {
    public static void main(String[] args) {

    }


    public List<Integer> inorderTraversal(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        if (root.left == null && root.right == null) {
            List<Integer> resultList = new ArrayList<>();
            resultList.add(root.val);
            return resultList;
        }

        List<Integer> list = inorderTraversal(root.left);
        list.add(root.val);
        list.addAll(inorderTraversal(root.right));
        return list;
    }

}
