package binarytree.example;

import binarytree.node.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindPathEqualsExpectNum {
    public List<List<Integer>> FindPath(TreeNode root, int expectNumber) {
        find(root, expectNumber);
        return result;
    }

    private final List<List<Integer>> result = new ArrayList<>();
    private final List<Integer> curList = new ArrayList<>();
    private int sum;

    private void find(TreeNode root, int expectNumber) {
        if (root == null) {
            return;
        }
        curList.add(root.val);
        sum += root.val;
        if (isLeaf(root) && sum == expectNumber) {
            result.add(new ArrayList<>(curList));
        } else {
            find(root.left, expectNumber);
            find(root.right, expectNumber);
        }
        curList.remove(curList.size() - 1);
        sum -= root.val;
    }

    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }
}
