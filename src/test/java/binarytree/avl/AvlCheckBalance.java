package binarytree.avl;

import binarytree.node.TreeNode;
import binarytree.node.TreeNodeUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * 搜索二叉树练习
 */
public class AvlCheckBalance {

    @Test
    public void test() {
        TreeNode tree = TreeNodeUtils.buildBTree();
        boolean result = check(tree);
        Assert.assertTrue(result);

    }

    public boolean check(TreeNode root) {
        return chk(root) >= 0;
    }

    /**
     * 该函数做了两件事：
     * 1. 若以root为根节点的树是平衡二叉树，则返回该树的深度（>=0）
     * 2. 反之，则返回 -1，代表该树不是平衡二叉树。
     */
    private int chk(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lDepth = chk(root.left);
        int rDepth = chk(root.right);
        if (lDepth >= 0 && rDepth >= 0 && Math.abs(lDepth - rDepth) <= 1) {
            return Math.max(lDepth, rDepth) + 1;
        }
        return -1;
    }
}
