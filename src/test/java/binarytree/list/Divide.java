package binarytree.list;

import binarytree.list.entity.ListNode;

/**
 * 对于一个链表，我们需要用一个特定阈值完成对它的分化，使得小于等于这个值的结点移到前面，大于该值的结点在后面，同时保证两类结点内部的位置关系不变。
 *
 * 给定一个链表的头结点head，同时给定阈值val，请返回一个链表，使小于等于它的结点在前，大于等于它的在后，保证结点值不重复。
 *
 * 测试样例：
 * {1,4,2,5},3
 * {1,2,4,5}
 */
public class Divide {

    public ListNode listDivide(ListNode head, int val) {
        if (head == null || head.next == null) {
            return head;
        }
        //>=
        ListNode head1 = null;
        ListNode tail1 = null;
        //<
        ListNode head2 = null;
        ListNode tail2 = null;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val <= val) {
                if (head1 == null) {
                    head1 = cur;
                    tail1 = cur;
                } else {
                    tail1.next = cur;
                    tail1 = tail1.next;
                }
            } else {
                if (head2 == null) {
                    head2 = cur;
                    tail2 = cur;
                } else {
                    tail2.next = cur;
                    tail2 = tail2.next;
                }
            }
            cur = cur.next;
        }

        //关键细节：避免出现死循环！！！
        if (head1 != null) {
            tail1.next = null;
        }
        if (head2 != null) {
            tail2.next = null;
        }

        if (head1 != null) {
            tail1.next = head2;
            return head1;
        }
        return head2;
    }
}
