package binarytree.example;

import binarytree.node.TreeNode;
import binarytree.node.TreeNodeUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * 输入：
 * {1,2,3,#,#,4,5}
 * 复制
 * 返回值：
 * [[1],[3,2],[4,5]]
 * 复制
 * 说明：
 * 如题面解释，第一层是根节点，从左到右打印结果，第二层从右到左，第三层从左到右。
 *
 * 按照 “之字形” 遍历二叉树
 */
public class ZTraverse {

    @Test
    public void test() {
        TreeNode head = TreeNodeUtils.buildBTree();
        ArrayList<ArrayList<Integer>> result = Print(head);
        System.out.println(result);
    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int layer = 0;
        while (!queue.isEmpty()) {
            int layerSize = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < layerSize; i++) {
                TreeNode curNode = queue.poll();
                if (layer % 2 == 0) {
                    list.add(Objects.requireNonNull(curNode).val);
                } else {
                    list.add(0, Objects.requireNonNull(curNode).val);
                }
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
            layer++;
            result.add(list);
        }
        return result;
    }

}
