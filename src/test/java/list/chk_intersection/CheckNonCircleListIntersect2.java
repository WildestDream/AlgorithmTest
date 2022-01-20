package list.chk_intersection;

import list.entity.ListNode;

/**
 * 现在有两个无环单链表，若两个链表的长度分别为m和n，请设计一个时间复杂度为O(n + m)，额外空间复杂度为O(1)的算法，判断这两个链表是否相交。
 *
 * 给定两个链表的头结点headA和headB，请返回一个bool值，代表这两个链表是否相交。保证两个链表长度小于等于500
 *
 * 方法2 直接判断最后一个节点是否相同
 */
public class CheckNonCircleListIntersect2 {
    public boolean chkIntersect(ListNode headA, ListNode headB) {
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
}
