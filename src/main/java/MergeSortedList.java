/**
 * @author Daniel
 * @date 29/05/2018
 */
public class MergeSortedList {

    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode head = temp;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
                temp = temp.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
                temp = temp.next;
            }
        }

        while (l1 != null) {
            temp.next = l1;
            l1 = l1.next;
            temp = temp.next;
        }

        while (l2 != null) {
            temp.next = l2;
            l2 = l2.next;
            temp = temp.next;
        }
        return head.next;

    }
}
