package binarytree.list;

import binarytree.list.entity.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 现有两个升序链表，且链表中均无重复元素。请设计一个高效的算法，打印两个链表的公共值部分。
 *
 * 给定两个链表的头指针headA和headB，请返回一个vector，元素为两个链表的公共部分。请保证返回数组的升序。两个链表的元素个数均小于等于500。保证一定有公共值
 *
 * 测试样例：
 * {1,2,3,4,5,6,7},{2,4,6,8,10}
 * 返回：[2.4.6]
 */
public class CommonParts {
    public int[] findCommonParts(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode l1 = headA;
        ListNode l2 = headB;
        List<Integer> list = new ArrayList<>();
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                l1 = l1.next;
            } else if (l1.val > l2.val) {
                l2 = l2.next;
            } else {
                list.add(l1.val);
                l1 = l1.next;
                l2 = l2.next;
            }
        }
        return buildResult(list);
    }

    private int[] buildResult(List<Integer> list) {
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
