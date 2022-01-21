package list;

import list.entity.ListNode;
import list.util.ListNodeUtil;
import org.junit.Test;

import java.util.List;

/**
 * 删除有序链表中的重复元素
 *
 * 给出一个升序排序的链表，删除链表中的所有重复出现的元素，只保留原链表中只出现一次的元素。
 * 例如：
 * 给出的链表为1→2→3→3→4→4→5, 返回 1→2→5.
 *
 * 数据范围：链表长度 0 \le n \le 100000≤n≤10000，链表中的值满足 |val| \le 1000∣val∣≤1000
 * 要求：空间复杂度 O(n)O(n)，时间复杂度 O(n)O(n)
 * 进阶：空间复杂度 O(1)O(1)，时间复杂度 O(n)O(n)
 */
public class DeleteDuplicates {

    @Test
    public void test() {
        ListNode head = ListNodeUtil.buildList(1, 2, 3, 3, 4, 4, 4, 5);
        ListNode resultList = deleteDuplicates(head);
        List<Integer> list = ListNodeUtil.getList(resultList);
        System.out.println(list);
    }

    @Test
    public void test2() {
        ListNode head = ListNodeUtil.buildList(1, 1, 1);
        ListNode resultList = deleteDuplicates(head);
        List<Integer> list = ListNodeUtil.getList(resultList);
        System.out.println(list);
    }

    @Test
    public void test3() {
        ListNode head = ListNodeUtil.buildList(1, 1, 1, 2, 2, 2, 2, 3);
        ListNode resultList = deleteDuplicates(head);
        List<Integer> list = ListNodeUtil.getList(resultList);
        System.out.println(list);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode mockHead = new ListNode(-1);
        mockHead.next = head;
        ListNode cur = mockHead;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val != cur.next.next.val) {
                cur = cur.next;
            } else {
                ListNode f = cur.next;
                while (f.next != null) {
                    if (f.val == f.next.val) {
                        f = f.next;
                    } else {
                        break;
                    }
                }
                cur.next = f.next;
            }
        }
        return mockHead.next;
    }
}
