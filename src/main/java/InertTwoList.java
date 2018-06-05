/**
 * @author Daniel
 * @date 04/06/2018
 */
public class InertTwoList {
    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        if (headA == headB) {
            return headA
                    ;
        }


        int sumA = 0;
        ListNode p = headA;
        while (p.next != null) {
            sumA++;
            p = p.next;
        }

        int sumB = 0;
        ListNode q = headB;
        while (q.next != null) {
            sumB++;
            q = q.next;
        }


        int sub = 0;
        if (sumA > sumB) {
            sub = sumA - sumB;
            while (sub > 0) {
                headA = headA.next;
                sub--;
            }
        } else {
            sub = sumB - sumA;
            while (sub > 0) {
                headB = headB.next;
                sub--;
            }
        }


        while (headA != null) {
            if (headA.next == headB.next) {
                return headA.next;
            }

            headA = headA.next;
            headB = headB.next;

        }

        return null;
    }
}
