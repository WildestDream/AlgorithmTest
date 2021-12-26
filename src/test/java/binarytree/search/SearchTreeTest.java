package binarytree.search;

import binarytree.node.TreeNode;
import binarytree.node.TreeNodeUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class SearchTreeTest {

    @Test
    public void test() {
        TreeNode treeNode = TreeNodeUtils.buildBTree();
        boolean result = checkIsSearch(treeNode);
        Assert.assertFalse(result); //不是搜索树
    }

    @Test
    public void test2() {
        TreeNode treeNode = TreeNodeUtils.buildSearchBTree();
        boolean result = checkIsSearch(treeNode);
        Assert.assertTrue(result);//是搜索树
    }

    /**
     * 判断以root作为根节点的二叉树是不是搜索二叉树
     */
    private boolean checkIsSearch(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode preCur = null;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (preCur != null && cur.val < preCur.val) {
                    return false;
                }
                preCur = cur;
                cur = cur.right;
            }
        }
        return true;
    }

    /**
     * 方式2，采用递归的方式
     */
    private boolean checkIsSearch2(TreeNode root) {
        return traverse(root);
    }

    private TreeNode preNode;

    private boolean traverse(TreeNode node) {
        if (node == null) {
            return true;
        }
        boolean lResult = traverse(node.left);
        if (!lResult) {
            return false;
        }
        if (preNode != null && node.val < preNode.val) {
            return false;
        }
        preNode = node;
        boolean rResult = traverse(node.right);
        if (!rResult) {
            return false;
        }
        return true;
    }
}
