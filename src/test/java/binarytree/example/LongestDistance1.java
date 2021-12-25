package binarytree.example;

import binarytree.node.TreeNode;

/**
 * 树上的最远距离练习题，视频中的方法，比较麻烦，需要分三种情况讨论
 */
public class LongestDistance1 {
    public int findLongest(TreeNode root) {
        return findMaxLen(root);
    }

    private int findMaxLen(TreeNode root){
        if(root == null){
            return 0;
        }
        //左子树上内部的最远距离
        int leftMaxLen = findMaxLen(root.left);
        //右子树内部的最远距离
        int rightMaxLen = findMaxLen(root.right);
        //最远距离的路径cross了root节点
        int crossRootMaxLen = maxStraightLen(root.left) + maxStraightLen(root.right) + 1;
        //三者取最大返回
        return Math.max(crossRootMaxLen, Math.max(leftMaxLen, rightMaxLen));
    }

    private int maxStraightLen(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(maxStraightLen(root.left) , maxStraightLen(root.right)) + 1;
    }
}
