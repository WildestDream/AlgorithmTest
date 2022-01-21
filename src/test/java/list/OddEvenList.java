package list;

import list.entity.ListNode;
import list.util.ListNodeUtil;
import org.junit.Test;

import java.util.List;

/**
 * 描述
 * 给定一个单链表，请设定一个函数，将链表的奇数位节点和偶数位节点分别放在一起，重排后输出。
 * 注意是节点的编号而非节点的数值。
 *
 * 输入：
 * {1,2,3,4,5,6}
 * 返回值：
 * {1,3,5,2,4,6}
 *
 * 输入：
 * {1,4,6,3,7}
 *
 * 返回值：
 * {1,6,7,4,3}
 */
public class OddEvenList {

    @Test
    public void test() {
        ListNode inputList = ListNodeUtil.buildList(1, 2, 3, 4);
        ListNode resultList = oddEvenList(inputList);
        List<Integer> list = ListNodeUtil.getList(resultList);
        System.out.println(list);
    }

    @Test
    public void test2() {
        ListNode inputList = ListNodeUtil.buildList(1, 2, 3, 4, 5);
        ListNode resultList = oddEvenList(inputList);
        List<Integer> list = ListNodeUtil.getList(resultList);
        System.out.println(list);
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode h1 = null;
        ListNode t1 = null;
        ListNode h2 = null;
        ListNode t2 = null;
        ListNode cur = head;
        int index = 0;
        while (cur != null) {
            if (index % 2 == 0) {
                if (t1 == null) {
                    h1 = cur;
                    t1 = cur;
                } else {
                    t1.next = cur;
                    t1 = t1.next;
                }
                //细节拉满，cur先向后移动，t1.next再清除
                cur = cur.next;
                t1.next = null;
            } else {
                if (t2 == null) {
                    h2 = cur;
                    t2 = cur;
                } else {
                    t2.next = cur;
                    t2 = t2.next;
                }
                cur = cur.next;
                t2.next = null;
            }
            index++;
        }
        t1.next = h2;
        return h1;
    }
}
