package binarytree.example;

import binarytree.node.TreeNode;

/**
 * 树上的最远距离练习题
 * 网友给出的方法，较为简单
 */
public class LongestDistance2 {
    public int findLongest(TreeNode root) {
        maxLen(root);
        return res;
    }

    //记录：在一次maxLen(node) 方法执行完成后。记录node为根节点的子树里的树上最远距离
    private int res;

    //返回到root节点的最远距离
    private int maxLen(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxLen(root.left);
        int rightMax = maxLen(root.right);
        res = Math.max(leftMax + rightMax + 1, res);
        return Math.max(leftMax, rightMax) + 1;
    }
}
