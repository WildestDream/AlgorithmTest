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
        return isBalance(root);
    }

    /**
     * 以 node 为根节点的二叉树，同时满足：
     * 1. 左子树是AVL数
     * 2. 右子树是AVL数
     * 3. 两树的高度差 ≤ 1
     */
    private boolean isBalance(TreeNode node) {
        if (node == null) {
            return true;
        }
        return isBalance(node.left) && isBalance(node.right) && Math.abs(len(node.left) - len(node.right)) <= 1;
    }


    public int len(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = len(node.left);
        int right = len(node.right);
        return Math.max(left, right) + 1; //记得加1
    }
}
