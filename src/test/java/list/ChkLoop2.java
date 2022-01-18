package list;

import list.entity.ListNode;

/**
 * 如何判断一个单链表是否有环？有环的话返回进入环的第一个节点的值，无环的话返回-1。如果链表的长度为N，请做到时间复杂度O(N)，额外空间复杂度O(1)。
 *
 * 方法1：使用hash表，但是满足空间复杂度O(1)
 */
public class ChkLoop2 {

    public int chkLoop(ListNode head, int adjust) {
        if (head == null) {
            return -1;
        }
        ListNode low = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            low = low.next;
            fast = fast.next.next;
            if (low == fast) {
                break;
            }
        }
        if (low != fast) {
            return -1;
        }
        fast = head;
        while (low != fast) {
            low = low.next;
            fast = fast.next;
        }
        return low.val;
    }
}
