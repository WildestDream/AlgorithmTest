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
 */
public class Palindrome {
    public boolean isPalindrome(ListNode pHead) {
        if (pHead == null) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        ListNode cur = pHead;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        int compareCnt = stack.size() % 2 == 0 ? stack.size() / 2 : (stack.size() - 1) / 2;
        cur = pHead;
        while (compareCnt > 0) {
            Integer val = stack.pop();
            if (val != cur.val) {
                return false;
            }
            cur = cur.next;
            compareCnt--;
        }
        return true;
    }
}
