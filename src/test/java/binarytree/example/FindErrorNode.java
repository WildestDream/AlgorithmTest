package binarytree.example;

import binarytree.node.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 寻找搜索二叉树上的两个错误节点
 * 本质考察中序遍历 + 观察，总结归纳能力
 */
public class FindErrorNode {
    private final List<Integer> list = new ArrayList<>();

    public int[] findError(TreeNode root) {
        midTraverse(root);
        if (list.isEmpty() || list.size() == 1) {
            return null;
        }
        List<Integer> errorNodes = new ArrayList<>();
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                errorNodes.add(list.get(i));
                errorNodes.add(list.get(i + 1));
            }
        }
        if (errorNodes.isEmpty()) {
            return null;
        }
        if (errorNodes.size() == 2) {
            return new int[]{errorNodes.get(1), errorNodes.get(0)};
        }
        if (errorNodes.size() == 4) {
            return new int[]{errorNodes.get(3), errorNodes.get(0)};
        }
        throw new RuntimeException("unknown error");
    }

    private void midTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        midTraverse(root.left);
        list.add(root.val);
        midTraverse(root.right);
    }

}
