package binarytree.traversal;

import binarytree.node.TreeNode;
import binarytree.node.TreeNodeUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * 分层遍历的第二种方式，更加的简单，清晰
 */
public class LevelTraverse2 {

    private TreeNode head;

    @Before
    public void init() {
        head = TreeNodeUtils.buildBTree();
    }

    private List<List<Integer>> traverse(TreeNode head) {
        if (head == null) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int layerSize = queue.size();
            for (int i = 0; i < layerSize; i++) {
                TreeNode curNode = queue.poll();
                list.add(Objects.requireNonNull(curNode).val);
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
            result.add(list);
        }
        return result;
    }

    private int[][] buildRes(List<List<Integer>> lists) {
        int[][] res = new int[lists.size()][];
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> list = lists.get(i);
            res[i] = new int[list.size()];
            for (int j = 0; j < list.size(); j++) {
                res[i][j] = list.get(j);
            }
        }
        return res;
    }


    @Test
    public void test() {
        List<List<Integer>> result = traverse(head);
        int[][] ints = buildRes(result);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }
}
