package binarytree.list;

import binarytree.list.entity.ListNode;
import org.junit.Test;

import java.util.Stack;

/**
 * 有一个单链表，请设计一个算法，使得每K个节点之间逆序，如果最后不够K个节点一组，则不调整最后几个节点。
 * 例如链表1->2->3->4->5->6->7->8->null，K=3这个例子。调整后为，3->2->1->6->5->4->7->8->null。
 * 因为K==3，所以每三个节点之间逆序，但其中的7，8不调整，因为只有两个节点不够一组。
 *
 * 给定一个单链表的头指针head,同时给定K值，返回逆序后的链表的头指针。
 */
public class KInverse {

    @Test
    public void test() {
        //0,1,2,5,11 2
        ListNode n1 = new ListNode(0);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(11);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode inverse = inverse(n1, 2);
        System.out.println(inverse);
    }

    public ListNode inverse(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        ListNode p1 = head;
        ListNode p2 = head;
        while (p1 != null) {
            stack.push(p1.val);
            if (stack.size() == k) {
                while (!stack.isEmpty()) {
                    p2.val = stack.pop();
                    p2 = p2.next;
                }
            }
            p1 = p1.next;
        }
        return head;
    }
}
