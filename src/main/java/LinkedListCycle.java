import java.util.HashMap;

/**
 * @author Daniel
 * @date 25/05/2018
 */
public class LinkedListCycle {

    public static void main(String[] args) {

    }

    // 有附加空间的版本
    public boolean hasCycle(ListNode head) {

        HashMap<ListNode, String> nodeSet = new HashMap<>();

        while (head != null) {
            if (nodeSet.containsKey(head)) {
                return true;
            }

            nodeSet.put(head, "1");
            head = head.next;
        }

        return false;
    }


}

class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

