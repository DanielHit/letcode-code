import java.util.*;

/**
 * @author Daniel
 * @date 25/05/2018
 */
public class Traversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(levelOrder(root));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();

        if (root == null) {
            return lists;
        }

        if (root.left == null && root.right == null) {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            lists.add(list);
            return lists;
        }


        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        lists.add(list);

        List<List<Integer>> leftLists = levelOrder(root.left);
        List<List<Integer>> rightLists = levelOrder(root.right);

        if (leftLists == null) {
            lists.addAll(rightLists);
            return lists;
        }

        if (rightLists == null) {
            lists.addAll(leftLists);
            return lists;
        }


        int i = 0;
        int j = 0;

        while (i < leftLists.size() && j < rightLists.size()) {
            List<Integer> tempList = new ArrayList<>();
            tempList.addAll(leftLists.get(i));
            tempList.addAll(rightLists.get(j));
            lists.add(tempList);
            i++;
            j++;
        }

        if (i < leftLists.size()) {
            lists.addAll(leftLists.subList(i, leftLists.size()));
        }

        if (j < rightLists.size()) {
            lists.addAll(rightLists.subList(j, rightLists.size()));
        }

        return lists;


    }

}
