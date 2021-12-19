package binarytree.traversal;

import binarytree.node.TreeNode;
import binarytree.node.TreeNodeUtils;
import org.junit.Before;
import org.junit.Test;

public class RecursionTraverse {

    private TreeNode head;

    @Before
    public void init() {
        head = TreeNodeUtils.buildBTree();
    }

    //前序遍历
    private void traverse1(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.val + " ");
        traverse1(head.left);
        traverse1(head.right);
    }

    //中序遍历
    private void traverse2(TreeNode head) {
        if (head == null) {
            return;
        }
        traverse2(head.left);
        System.out.print(head.val + " ");
        traverse2(head.right);
    }

    //后序遍历
    private void traverse3(TreeNode head) {
        if (head == null) {
            return;
        }
        traverse3(head.left);
        traverse3(head.right);
        System.out.print(head.val + " ");
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
