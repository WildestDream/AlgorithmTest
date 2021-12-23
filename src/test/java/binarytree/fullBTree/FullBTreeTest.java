package binarytree.fullBTree;

import binarytree.node.TreeNode;
import binarytree.node.TreeNodeUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class FullBTreeTest {

    @Test
    public void test() {
        TreeNode head = TreeNodeUtils.buildNonFullBTree();
        boolean chk = chk(head);
        Assert.assertFalse(chk);
    }

    public boolean chk(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (flag) {
                if (cur.left != null || cur.right != null) {
                    return false;
                }
            }
            if (cur.left == null && cur.right != null) {
                return false;
            }
            if (cur.left == null || cur.right == null) {
                flag = true;
            }
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        return true;
    }
}
