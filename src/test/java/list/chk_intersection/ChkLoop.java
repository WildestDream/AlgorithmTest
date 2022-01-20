package list.chk_intersection;

import list.entity.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 如何判断一个单链表是否有环？有环的话返回进入环的第一个节点的值，无环的话返回-1。如果链表的长度为N，请做到时间复杂度O(N)，额外空间复杂度O(1)。
 *
 * 方法1：使用hash表，但是满足空间复杂度O(1)
 */
public class ChkLoop {

    public int chkLoop(ListNode head, int adjust) {
        if (head == null) {
            return -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        ListNode cur = head;
        while (cur != null) {
            if (map.containsKey(cur.hashCode())) {
                return cur.val;
            }
            map.put(cur.hashCode(), 1);
            cur = cur.next;
        }
        return -1;
    }
}
