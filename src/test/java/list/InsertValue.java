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
 * 方法1，
 * 现在数组中插入val，再将数组构建成为一个环形链表
 */
public class InsertValue {

    public ListNode insert(int[] A, int[] nxt, int val) {
        int[] nodes = new int[A.length + 1];
        int index = 0;
        boolean add = false;
        for (int a : A) {
            if (a > val && !add) {
                nodes[index++] = val;
                add = true;
            }
            nodes[index++] = a;
        }
        //待插入的值比所有的值都大
        if (!add) {
            nodes[index++] = val;
        }
        return buildList(nodes);
    }

    private ListNode buildList(int[] nodes) {
        ListNode head = new ListNode(nodes[0]);
        if (nodes.length == 1) {
            return head;
        }
        ListNode cur = head;
        ListNode node;
        for (int i = 1; i < nodes.length; i++) {
            node = new ListNode(nodes[i]);
            cur.next = node;
            cur = cur.next;
        }
        cur.next = null; //按道理应该 cur.next = head, 但是这样的话，就会一直循环得不到结果
        return head;
    }
}
