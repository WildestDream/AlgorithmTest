package binarytree.traversal;

import binarytree.node.TreeNode;
import binarytree.node.TreeNodeUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelTraverse {

    private TreeNode head;

    @Before
    public void init() {
        head = TreeNodeUtils.buildBTree();
    }

    //不要求打印行号
    private void traverse(TreeNode head) {
        if (head == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.print(cur.val + " ");
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }

    //打印行号
    private void traverseWithLineNum(TreeNode head) {
        if (head == null) {
            return;
        }
        List<List<TreeNode>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        TreeNode last = head; //当前行的最右边节点
        TreeNode nLast = null; //下一行的最右边节点
        List<TreeNode> curLevelResult = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            curLevelResult.add(cur);
            if (cur.left != null) {
                queue.offer(cur.left);
                nLast = cur.left;
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                nLast = cur.right;
            }
            if (cur == last) {
                result.add(curLevelResult);
                curLevelResult = new ArrayList<>();
                last = nLast;
            }
        }
        print(result);
    }

    private void print(List<List<TreeNode>> result) {
        for (List<TreeNode> level : result) {
            for (TreeNode treeNode : level) {
                System.out.print(treeNode.val + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void test() {
        traverseWithLineNum(head);
    }
}
