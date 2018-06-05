/**
 * @author Daniel
 * @date 05/06/2018
 */
public class ReverseList {
    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        ListNode p = head;
        ListNode q = p.next;

        if (p == null) {
            return null;
        }
        if (q == null) {
            return p;
        }

        if (q.next == null) {
            q.next = p;
            p.next = null;
            return q;
        }

        while (q.next != null) {
            ListNode temp = q.next;
            q.next = p;
            p = q;
            q = temp;
        }

        head.next = null;
        q.next = p;
        return q;
    }
}
