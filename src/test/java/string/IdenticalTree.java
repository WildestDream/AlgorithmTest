package string;

import binarytree.node.TreeNode;

/**
 * 对于两棵彼此独立的二叉树A和B，请编写一个高效算法，检查A中是否存在一棵子树与B树的拓扑结构完全相同。
 *
 * 给定两棵二叉树的头结点A和B，请返回一个bool值，代表A中是否存在一棵同构于B的子树。
 */
public class IdenticalTree {
    public boolean chkIdentical(TreeNode A, TreeNode B) {
        StringBuilder builder1 = new StringBuilder();
        StringBuilder builder2 = new StringBuilder();
        traverse(A, builder1);
        traverse(B, builder2);
        return builder1.toString().contains(builder2.toString());
    }

    private void traverse(TreeNode root, StringBuilder builder) {
        if (root == null) {
            builder.append("#!");
            return;
        }
        builder.append(root.val).append("!");
        traverse(root.left, builder);
        traverse(root.right, builder);
    }
}
