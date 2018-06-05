import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Daniel
 * @date 30/05/2018
 */
public class CombinationSum {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, 7};

        List<List<Integer>> list = combination(nums, 8);
//        List<List<Integer>> list = combinationSum(nums, 10);

        // 相似的问题如何排查?
        System.out.println(list);

    }


    // 如果相同如何处理?
    public static List<List<Integer>> combination(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(res, temp, target, candidates, 0);
        return res;

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> list = new ArrayList<>();

        if (target <= 0) {
            return new ArrayList<>();
        }

        for (int i = 0; i < candidates.length; i++) {

            if (candidates[i] == target) {
                List<Integer> tempList = new ArrayList<>();
                tempList.add(candidates[i]);
                list.add(tempList);
                continue;
            }

            if (candidates[i] > target) {
                continue;
            }

            List<List<Integer>> subList = combinationSum(candidates, target - candidates[i]);
            if (!subList.isEmpty()) {
                for (int j = 0; j < subList.size(); j++) {
                    subList.get(j).add(candidates[i]);
                }
            }

            list.addAll(subList);
        }

        return list;
    }

    private static void dfs(List<List<Integer>> res, List<Integer> temp, int target,
                            int[] candidates, int j) {
        //满足条件，将中间集加入结果集
        if (target == 0) {
            res.add(new ArrayList<>(temp));
        }

        //target>=candidates[i]是剪枝操作
        for (int i = j; i < candidates.length && target >= candidates[i]; i++) {
            temp.add(candidates[i]);
            dfs(res, temp, target - candidates[i], candidates, i);
            temp.remove(temp.size() - 1);
        }


    }


}
