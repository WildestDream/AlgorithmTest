package list;

import list.entity.ListNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 描述
 * 编号为 1 到 n 的 n 个人围成一圈。从编号为 1 的人开始报数，报到 m 的人离开。
 * 下一个人继续从 1 开始报数。
 * n-1 轮结束以后，只剩下一个人，问最后留下的这个人编号是多少？
 *
 * 数据范围： 1 \le n , m \le 100001≤n,m≤10000
 * 进阶：空间复杂度 O(1)O(1)，时间复杂度 O(n)O(n)
 *
 * 输入：5,2
 * 输出：3
 * 说明：
 * 开始5个人 1，2，3，4，5 ，从1开始报数，1->1，2->2编号为2的人离开
 * 1，3，4，5，从3开始报数，3->1，4->2编号为4的人离开
 * 1，3，5，从5开始报数，5->1，1->2编号为1的人离开
 * 3，5，从3开始报数，3->1，5->2编号为5的人离开
 * 最后留下人的编号是3
 *
 */
public class CircleRSF {

    @Test
    public void test() {
        int result = ysf(1, 1);
        Assert.assertEquals(1, result);
    }

    @Test
    public void test2() {
        int result = ysf(5, 2);
        Assert.assertEquals(3, result);
    }

    @Test
    public void test3() {
        int result = ysf(3, 3);
        Assert.assertEquals(2, result);
    }

    public int ysf(int n, int m) {
        if (n == 1) {
            return 1;
        }
        if (m == 1) {
            return n;
        }
        ListNode head = buildCircleList(n);
        ListNode p1 = head;
        ListNode p2 = head.next;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 2; j++) {
                p1 = p1.next;
                p2 = p2.next;
            }
            p1.next = p1.next.next;
            p1 = p1.next;
            p2 = p1.next;
        }
        return p1.val;
    }

    private ListNode buildCircleList(int n) {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 2; i <= n; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        cur.next = head;
        return head;
    }
}
