package binarytree.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 链表反转
 */
public class ReverseList {

    @Test
    public void test() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode head = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = null;
        System.out.println(getList(head));
        ListNode newHead = ReverseList(head);
        System.out.println(getList(newHead));
    }

    private List<Integer> getList(ListNode head) {
        List<Integer> result = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            result.add(cur.val);
            cur = cur.next;
        }
        return result;
    }

    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode p3 = head.next.next;
        head.next = null;

        while (true) {
            p2.next = p1;
            p1 = p2;
            p2 = p3;
            if (p2 == null) {
                break;
            }
            p3 = p2.next;
        }
        return p1;
    }
}
