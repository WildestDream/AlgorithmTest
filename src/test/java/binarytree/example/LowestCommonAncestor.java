package binarytree.example;

import binarytree.node.TreeNode;
import binarytree.node.TreeNodeUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**

 给定一棵二叉树(保证非空)以及这棵树上的两个节点对应的val值 o1 和 o2，请找到 o1 和 o2 的最近公共祖先节点。

 */
public class LowestCommonAncestor {

    private final Map<Integer, Integer> map = new HashMap<>();

    private int count;

    public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        //初始化每个节点的父节点(o1,o2 遍历到便停止，没必要收集所有节点的父节点)
        initParents(root, o1, o2);
        //从o1向上找，依次找到父节点，串联起来
        List<Integer> trace1 = buildTrace(o1);
        //从o2向上找，依次找到父节点，串联起来
        List<Integer> trace2 = buildTrace(o2);
        //从顶级父节点开始，找到最后一个相同的节点，就是最近的公共节点
        return findLastSameNode(trace1, trace2);
    }

    private int findLastSameNode(List<Integer> trace1, List<Integer> trace2) {
        int index1 = trace1.size() - 1;
        int index2 = trace2.size() - 1;
        while (index1 >= 0 && index2 >= 0 && trace1.get(index1).equals(trace2.get(index2))) {
            index1--;
            index2--;
        }
        return trace1.get(index1 + 1);
    }

    private List<Integer> buildTrace(int o) {
        List<Integer> traceList = new ArrayList<>();
        traceList.add(o);
        Integer parent = map.get(o);
        while (parent != null) {
            traceList.add(parent);
            parent = map.get(parent);
        }
        return traceList;
    }

    private void initParents(TreeNode root, int o1, int o2) {
        map.put(root.val, null); //注意：顶级节点需要特殊处理一下
        initMap(root, o1, o2);
    }

    private void initMap(TreeNode node, int o1, int o2) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            if (count >= 2) {
                return;
            }
            map.put(node.left.val, node.val);
            if (node.left.val == o1 || node.left.val == o2) {
                count++;
            }
            initMap(node.left, o1, o2);
        }
        if (node.right != null) {
            if (count >= 2) {
                return;
            }
            map.put(node.right.val, node.val);
            if (node.right.val == o1 || node.right.val == o2) {
                count++;
            }
            initMap(node.right, o1, o2);
        }
    }


    @Test
    public void test2() {
        TreeNode root = TreeNodeUtils.buildBTree();
        int res = lowestCommonAncestor(root, 4, 5);
        Assert.assertEquals(2, res);
    }

    @Test
    public void test3() {
        TreeNode root = TreeNodeUtils.buildBTree();
        int res = lowestCommonAncestor(root, 4, 7);
        Assert.assertEquals(1, res);
    }

    @Test
    public void test() {
        TreeNode root = TreeNodeUtils.buildBTree();
        initParents(root, 2, 3);
        System.out.println(map);
    }
}
