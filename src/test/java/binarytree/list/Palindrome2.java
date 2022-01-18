package binarytree.list;

import binarytree.list.entity.ListNode;

import java.util.Stack;

/**
 * 请编写一个函数，检查链表是否为回文。
 *
 * 给定一个链表ListNode* pHead，请返回一个bool，代表链表是否为回文。
 *
 * 测试样例：
 * {1,2,3,2,1}
 * 返回：true
 * {1,2,3,2,3}
 * 返回：false
 *
 * 方法2：使用快慢指针，stack中存储的数据少了一半
 */
public class Palindrome2 {
    public boolean isPalindrome(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        ListNode slowCur = pHead;
        ListNode fastCur = pHead;
        while (fastCur != null && fastCur.next != null) {
            stack.push(slowCur.val);
            slowCur = slowCur.next;
            fastCur = fastCur.next.next;
        }
        if (fastCur != null) {
            slowCur = slowCur.next;
        }
        while (!stack.isEmpty()) {
            if (stack.pop() != slowCur.val) {
                return false;
            }
            slowCur = slowCur.next;
        }
        return true;
    }
}
