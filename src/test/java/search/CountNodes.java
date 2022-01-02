package search;

import binarytree.node.TreeNode;
import binarytree.node.TreeNodeUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * 给定一棵完全二叉树的根节点root，返回这棵树的节点个数。如果完全二叉树的节点数为N，请实现时间复杂度低于O(N)的解法。
 *
 * 给定树的根结点root，请返回树的大小。
 */
public class CountNodes {

    @Test
    public void test() {
        TreeNode root = TreeNodeUtils.buildBTree();
        int count = count(root);
        Assert.assertEquals(7, count);
    }

    public int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftH = calH(root.left);
        int rightH = calH(root.right);
        if (leftH == rightH) {
            //左右子树的高度相同，则左子树一定是满二叉树，可以根据公式快速计算
            return (int) Math.pow(2, leftH) - 1 + count(root.right) + 1;
        } else {
            //左右子树的高度不同（肯定右子树的高度低），则右子树一定是满二叉树，可以根据公式快速计算
            return (int) Math.pow(2, rightH) - 1 + count(root.left) + 1;
        }
    }

    //获取以root为头的完全二叉树的深度
    private int calH(TreeNode root) {
        TreeNode cur = root;
        int h = 0;
        while (cur != null) {
            h++;
            cur = cur.left;
        }
        return h;
    }
}
