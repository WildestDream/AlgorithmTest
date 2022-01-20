package list.chk_intersection;

import list.entity.ListNode;

/**
 * 现在有两个无环单链表，若两个链表的长度分别为m和n，请设计一个时间复杂度为O(n + m)，额外空间复杂度为O(1)的算法，判断这两个链表是否相交。
 *
 * 给定两个链表的头结点headA和headB，请返回一个bool值，代表这两个链表是否相交。保证两个链表长度小于等于500
 */
public class CheckNonCircleListIntersect {
    public boolean chkIntersect(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return false;
        }
        int len1 = len(headA);
        int len2 = len(headB);
        int step = Math.abs(len1 - len2);
        if (len1 < len2) {
            move(headB, step);
        } else {
            move(headA, step);
        }
        while (headA != null && headB != null) {
            if (headA == headB) {
                return true;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return false;
    }

    private void move(ListNode head, int step) {
        for (int i = 0; i < step; i++) {
            head = head.next;
        }
    }

    private int len(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}
