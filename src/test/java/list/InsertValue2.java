package list;

import list.entity.ListNode;

/**
 * 有一个整数val，如何在节点值有序的环形链表中插入一个节点值为val的节点，并且保证这个环形单链表依然有序。
 *
 * 给定链表的信息，及元素的值A及对应的nxt指向的元素编号同时给定val，请构造出这个环形链表，并插入该值。
 *
 * 测试样例：
 * [1,3,4,5,7],[1,2,3,4,0],2
 * 返回：{1,2,3,4,5,7}
 *
 * 方法2，
 * 先构建环形链表，再插入值val
 *
 * 但是其实并没有构建环形链表，否则无法输出。
 */
public class InsertValue2 {

    public ListNode insert(int[] A, int[] nxt, int val) {
        ListNode head = buildList(A);
        if (head == null) {
            return new ListNode(val);
        }
        ListNode p1 = head;
        ListNode p2 = head.next;
        boolean add = false;
        while (p2 != null) {
            if (val >= p1.val && val <= p2.val) {
                ListNode newNode = new ListNode(val);
                newNode.next = p2;
                p1.next = newNode;
                add = true;
                break;
            }
            p1 = p2;
            p2 = p2.next;
        }
        if (!add) {
            ListNode newNode = new ListNode(val);
            if (val <= head.val) {
                newNode.next = head;
                return newNode;
            } else {
                p1.next = newNode;
            }
        }
        return head;

    }

    private ListNode buildList(int[] nodes) {
        if (nodes == null || nodes.length == 0) {
            return null;
        }
        ListNode preNode = new ListNode(nodes[0]);
        ListNode head = preNode;
        if (nodes.length == 1) {
            return head;
        }
        for (int i = 1; i < nodes.length; i++) {
            ListNode curNode = new ListNode(nodes[i]);
            preNode.next = curNode;
            preNode = curNode;
        }
        return head;
    }
}
