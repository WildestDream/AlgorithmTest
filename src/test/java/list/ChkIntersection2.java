package list;

import list.entity.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 两个有环单链表判断是否相交
 *
 * 使用hashSet，更加简单，但是不满足O(1)
 */
public class ChkIntersection2 {
    public boolean chkInter(ListNode head1, ListNode head2, int adjust0, int adjust1) {
        if (head1 == null || head2 == null) {
            return false;
        }

        Set<Integer> set1 = new HashSet<>();
        while (!set1.contains(head1.hashCode())) {
            set1.add(head1.hashCode());
            head1 = head1.next;
        }

        Set<Integer> set2 = new HashSet<>();
        while (!set2.contains(head2.hashCode())) {
            if (set1.contains(head2.hashCode())) {
                return true;
            }
            set2.add(head2.hashCode());
            head2 = head2.next;
        }
        return false;
    }
}
