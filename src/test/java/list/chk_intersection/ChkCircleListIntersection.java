package list.chk_intersection;

import list.entity.ListNode;

/**
 * 两个有环单链表判断是否相交
 */
public class ChkCircleListIntersection {
    public boolean chkInter(ListNode head1, ListNode head2, int adjust0, int adjust1) {
        if (head1 == null || head2 == null) {
            return false;
        }
        ListNode firstNode1 = firstEnterCircleNode(head1);
        ListNode firstNode2 = firstEnterCircleNode(head2);
        if (firstNode1 == firstNode2) {
            return true;
        }
        ListNode flag = firstNode1;
        while (firstNode1 != firstNode2) {
            firstNode1 = firstNode1.next;
            if (firstNode1 == flag) {
                return false;
            }
        }
        return true;
    }

    private ListNode firstEnterCircleNode(ListNode head) {
        ListNode low = head.next;
        ListNode fast = head.next.next;
        while (low != fast) {
            low = low.next;
            fast = fast.next.next;
        }
        fast = head;
        while (fast != low) {
            fast = fast.next;
            low = low.next;
        }
        return low;
    }
}
