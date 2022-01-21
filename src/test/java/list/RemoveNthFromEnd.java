package list;

import list.entity.ListNode;
import list.util.ListNodeUtil;
import org.junit.Test;

/**
 * 删除倒数第N个节点
 */
public class RemoveNthFromEnd {


    @Test
    public void test() {
        ListNode list = ListNodeUtil.buildList(1, 2, 3, 4, 5);
        ListNode result = removeNthFromEnd(list, 2);
        System.out.println(ListNodeUtil.getList(result));
    }

    @Test
    public void test2() {
        ListNode list = ListNodeUtil.buildList(1, 2);
        ListNode result = removeNthFromEnd(list, 2);
        System.out.println(ListNodeUtil.getList(result));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        for (int i = 0; i < n && p2 != null; i++) {
            p2 = p2.next;
        }
        //若p2 = null， 代表要删除的节点就是头节点，则需要特殊处理
        if (p2 == null) {
            return head.next;
        }
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p1.next.next;
        return head;
    }
}
