package list;

import list.entity.ListNode;
import list.util.ListNodeUtil;
import org.junit.Test;

import java.util.List;
import java.util.Stack;

/**
 * 两个链表相加 模仿大数相加
 * 假设链表中每一个节点的值都在 0 - 9 之间，那么链表整体就可以代表一个整数。
 * 给定两个这种链表，请生成代表两个整数相加值的结果链表。
 * 要求：空间复杂度 O(n)，时间复杂度 O(n)
 *
 * 例如：链表 1 为 9->3->7，链表 2 为 6->3，最后生成新的结果链表为 1->0->0->0。
 */
public class ListAdd {

    @Test
    public void test() {
        ListNode head1 = ListNodeUtil.buildList(9, 3, 7);
        ListNode head2 = ListNodeUtil.buildList(6, 3);
        ListNode resultHead = addInList(head1, head2);
        List<Integer> result = ListNodeUtil.getList(resultHead);
        System.out.println(result);
    }

    public ListNode addInList(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Stack<Integer> stack1 = putValsToStack(head1);
        Stack<Integer> stack2 = putValsToStack(head2);
        int carry = 0;//进位
        ListNode nextNode = null;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int num1 = stack1.isEmpty() ? 0 : stack1.pop();
            int num2 = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = num1 + num2 + carry;
            carry = sum >= 10 ? 1 : 0;
            ListNode cur = new ListNode(sum % 10);
            cur.next = nextNode;
            nextNode = cur;
        }
        //记得检查是否最后也进了个1
        if(carry != 0){
            ListNode cur = new ListNode(1);
            cur.next = nextNode;
            nextNode = cur;
        }
        return nextNode;
    }

    private Stack<Integer> putValsToStack(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        return stack;
    }
}
