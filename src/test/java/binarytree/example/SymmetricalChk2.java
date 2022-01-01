package binarytree.example;

import binarytree.node.TreeNode;

/**
 * 对称二叉树判断
 * 递归
 *
 */
public class SymmetricalChk2 {

    boolean isSymmetrical(TreeNode root) {
        return chk(root, root);
    }

    //以 root1 为头结点的二叉树 与 以root2为头结点的二叉树是不是对称的
    private boolean chk(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root2 == null) {
            return false;
        }
        return root1.val == root2.val && chk(root1.left, root2.right) && chk(root1.right, root2.left);
    }
}
