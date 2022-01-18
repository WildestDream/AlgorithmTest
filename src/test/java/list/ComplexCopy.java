package list;

import list.entity.RandomListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ComplexCopy {

    @Test
    public void test() {
        RandomListNode n1 = new RandomListNode(1);
        RandomListNode n2 = new RandomListNode(2);
        RandomListNode n3 = new RandomListNode(3);
        RandomListNode n4 = new RandomListNode(4);
        RandomListNode n5 = new RandomListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n1.random = n3;
        n2.random = n5;
        n4.random = n2;
        RandomListNode result = Clone(n1);
        List<Integer> list = collectToList(result);
        System.out.println(list);
    }

    private List<Integer> collectToList(RandomListNode head) {
        List<Integer> res = new ArrayList<>();
        while (head != null) {
            res.add(head.label);
            head = head.next;
        }
        return res;
    }

    public RandomListNode Clone(RandomListNode head) {
        //一个节点的时候，也需要复制，不能直接返回
        if (head == null) {
            return null;
        }
        //第一遍遍历：在每个node插入自己的复制节点，形成 1->1->2->2->3->3->null
        RandomListNode cur = head;
        while (cur != null) {
            RandomListNode insertNode = new RandomListNode(cur.label);
            insertNode.next = cur.next;
            cur.next = insertNode;
            cur = cur.next.next;
        }
        cur = head;
        //第二遍遍历：设置新节点的random指针，注意random==null 的情况
        while (cur != null) {
            cur.next.random = cur.random != null ? cur.random.next : null;
            cur = cur.next.next;
        }
        //第三遍遍历：链表分化（注意一定要分化，而不是在1->1->2->2->3->3->null直接删除节点）
        RandomListNode p1 = head;
        RandomListNode p2 = head.next;
        RandomListNode res = p2;
        while (true) {
            p1.next = p1.next.next;
            if (p2.next == null) {
                break;
            }
            p2.next = p2.next.next;
            p1 = p1.next;
            p2 = p2.next;
        }
        return res;
    }
}
