/**
 * @author Daniel
 * @date 29/05/2018
 * <p>
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 */
public class RemoveNthNode {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode beforeP = new ListNode(0);
        beforeP.next = head;
        ListNode p = beforeP;
        head = beforeP;

        for (int i = 0; i < n; i++) {
            p = p.next;
        }

        while (p.next != null) {
            p = p.next;
            beforeP = beforeP.next;
        }

        beforeP.next = beforeP.next.next;

        return head.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

