package binarytree.example;

import binarytree.node.TreeNode;

/**
 * 对称二叉树判断
 *
 * 改进的中序遍历：即叶子节点的两个##不要打印，否则影响判断。
 * 例如：{1,2,3,3,#,2,#}
 *
 */
public class SymmetricalChk {

    boolean isSymmetrical(TreeNode pRoot) {
        traverse(pRoot);
        String s = builder.toString();
        String[] arr = s.split("!");
        if (arr.length == 0) {
            return true;
        }
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            if (!arr[start++].equals(arr[end--])) {
                return false;
            }
        }
        return true;
    }

    StringBuilder builder = new StringBuilder();

    private void traverse(TreeNode root) {
        if (root == null) {
            builder.append("#!");
            return;
        }
        if (isLeaf(root.left)) {
            builder.append(root.val).append("!");
            return;
        }
        traverse(root.left);
        builder.append(root.val).append("!");
        traverse(root.right);
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

}
