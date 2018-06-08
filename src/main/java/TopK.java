import java.util.*;

/**
 * @author Daniel
 * @date 08/06/2018
 */
public class TopK {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 3, 2, 3};
        System.out.println(new TopK().topKFrequent(nums, 2));
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> treeMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (treeMap.containsKey(nums[i])) {
                treeMap.put(nums[i], treeMap.get(nums[i]) + 1);
            } else {
                treeMap.put(nums[i], 1);
            }
        }

        List<Integer> list = new ArrayList<>();
        Set<Map.Entry<Integer, Integer>> set = treeMap.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterable = set.iterator();

        List<Node> listNode = new ArrayList<>();
        while (iterable.hasNext()) {
            Integer key = iterable.next().getKey();
            listNode.add(new Node(treeMap.get(key), key));
        }

        Collections.sort(listNode, (o1, o2) -> o2.number - o1.number);
        for (int i = 0; i < k; i++) {
            list.add(listNode.get(i).key);
        }
        return list;

    }

    class Node {
        public Node(Integer number, Integer key) {
            this.number = number;
            this.key = key;
        }

        public Integer number;
        public Integer key;
    }
}
