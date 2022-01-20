package list.chk_intersection;

import list.entity.ListNode;

/**
 * 最普遍的情况，两个单链表判断相交
 */
public class ChkIntersection {

    public boolean chkInter(ListNode head1, ListNode head2, int adjust0, int adjust1) {
        if (head1 == null || head2 == null) {
            return false;
        }
        ListNode firstEnterCircleNode1 = getFirstEnterCircleNode(head1);
        ListNode firstEnterCircleNode2 = getFirstEnterCircleNode(head2);
        if (firstEnterCircleNode1 == null && firstEnterCircleNode2 == null) {
            return checkNoCircleListIntersect(head1, head2);//1 两个无环
        } else if (firstEnterCircleNode1 != null && firstEnterCircleNode2 != null) {
            return checkCircleListIntersect(firstEnterCircleNode1, firstEnterCircleNode2);//2 两个有环
        } else {
            return false;//3.一个有环，一个无环
        }
    }

    private boolean checkCircleListIntersect(ListNode head1, ListNode head2) {
        if (head1 == head2) {
            return true;
        }
        ListNode flag = head1;
        while (head1 != head2) {
            head1 = head1.next;
            if (head1 == flag) {
                return false;
            }
        }
        return true;
    }

    public boolean checkNoCircleListIntersect(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return false;
        }
        return getLastNode(headA) == getLastNode(headB);
    }

    private ListNode getLastNode(ListNode head) {
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }

    private ListNode getFirstEnterCircleNode(ListNode head) {
        ListNode low = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            low = low.next;
            fast = fast.next.next;
            if (fast == low) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        fast = head;
        while (fast != low) {
            low = low.next;
            fast = fast.next;
        }
        return low;
    }
}