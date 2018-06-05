/**
 * @author Daniel
 * @date 04/06/2018
 */
public class SortList {

    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        node.next = new ListNode(2);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(3);

        ListNode node1 = sortList(node);
    }

    public static ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = sortList(head.next);

        if (head.val <= p.val) {
            head.next = p;
            return head;
        }

        while (p.next != null) {
            if (head.val >= p.val) {
                ListNode temp = head;
                head.next = p.next;
                p.next = head;
                return temp.next;
            }

            p = p.next;
        }

        p.next = head;
        ListNode temp = head.next;
        head.next = null;
        return temp;
    }
}
