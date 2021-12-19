package binarytree.traversal;

import binarytree.node.TreeNode;
import binarytree.node.TreeNodeUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.Stack;

/**
 * 非递归的遍历方式，重点
 */
public class NonRecursionTraverse {

    private TreeNode head;

    @Before
    public void init() {
        head = TreeNodeUtils.buildBTree();
    }

    //前序遍历, 利用一个 stack 实现。
    private void traverse1(TreeNode head) {
        if (head == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            System.out.print(cur.val + " ");
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    //中序遍历, 利用一个 stack 实现。
    private void traverse2(TreeNode head) {
        if (head == null) {
            return;
        }
        TreeNode cur = head;
        Stack<TreeNode> stack = new Stack<>();
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                System.out.print(cur.val + " ");
                cur = cur.right;
            }
        }
    }

    //后序遍历, 双栈实现
    private void traverse3(TreeNode head) {
        if (head == null) {
            return;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        TreeNode cur = head;
        stack1.push(cur);
        while (!stack1.isEmpty()) {
            cur = stack1.pop();
            stack2.push(cur);
            if (cur.left != null) {
                stack1.push(cur.left);
            }
            if (cur.right != null) {
                stack1.push(cur.right);
            }
        }
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().val + " ");
        }
    }

    //测试 前、中、后序遍历
    @Test
    public void test() {
        traverse1(head);
        System.out.println();
        traverse2(head);
        System.out.println();
        traverse3(head);
    }

}
