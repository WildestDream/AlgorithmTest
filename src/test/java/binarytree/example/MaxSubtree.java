package binarytree.example;

import binarytree.node.TreeNode;

/**
 * 最大的搜索二叉子树
 */
public class MaxSubtree {
    public TreeNode getMax(TreeNode root) {
        return traverse(root);
    }

    //min, max, count
    private final int[] res = new int[3];

    private TreeNode traverse(TreeNode root) {
        if (root == null) {
            res[0] = Integer.MAX_VALUE;
            res[1] = Integer.MIN_VALUE;
            res[2] = 0;
            return null;
        }

        TreeNode left = traverse(root.left);
        int leftMin = res[0];
        int leftMax = res[1];
        int leftCnt = res[2];

        TreeNode right = traverse(root.right);
        int rightMin = res[0];
        int rightMax = res[1];
        int rightCnt = res[2];

        if (left == root.left && right == root.right && leftMax <= root.val && rightMin >= root.val) {
            res[0] = left != null ? leftMin : root.val;
            res[1] = right != null ? rightMax : root.val;
            res[2] = leftCnt + rightCnt + 1;
            return root;
        } else {
            res[0] = leftCnt > rightCnt ? leftMin : rightMin;
            res[1] = leftCnt > rightCnt ? leftMax : rightMax;
            res[2] = Math.max(leftCnt, rightCnt);
            return leftCnt > rightCnt ? left : right;
        }
    }
}
