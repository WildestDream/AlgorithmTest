package list.util;

import list.entity.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ListNodeUtil {

    public static ListNode buildList(int... args) {
        if (args == null || args.length == 0) {
            return null;
        }
        ListNode head = new ListNode(args[0]);
        ListNode cur = head;
        for (int i = 1; i < args.length; i++) {
            cur.next = new ListNode(args[i]);
            cur = cur.next;
        }
        return head;
    }

    public static List<Integer> getList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list;
    }
}
