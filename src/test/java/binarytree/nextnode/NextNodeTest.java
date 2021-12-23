package binarytree.nextnode;

import lombok.Data;
import org.junit.Assert;
import org.junit.Test;

/**
 * 寻找后继节点练习
 */
public class NextNodeTest {

    @Data
    private static class FTreeNode {
        private int val;
        private FTreeNode parent;
        private FTreeNode left;
        private FTreeNode right;

        public FTreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "FTreeNode{" +
                    "val=" + val +
                    '}';
        }
    }

    @Test
    public void test() {
        FTreeNode n1 = new FTreeNode(1);
        FTreeNode n2 = new FTreeNode(2);
        FTreeNode n3 = new FTreeNode(3);
        FTreeNode n4 = new FTreeNode(4);
        FTreeNode n5 = new FTreeNode(5);
        FTreeNode n6 = new FTreeNode(6);
        FTreeNode n7 = new FTreeNode(7);
        n1.left = n2;
        n1.right = n3;

        n2.parent = n1;
        n2.left = n4;
        n2.right = n5;

        n3.parent = n1;
        n3.left = n6;
        n3.right = n7;

        n4.parent = n2;
        n5.parent = n2;

        n6.parent = n3;
        n7.parent = n3;

        Assert.assertEquals(n1, getNextNode(n5));
    }

    private FTreeNode getNextNode(FTreeNode root) {
        FTreeNode cur = root;
        if (cur == null) {
            return null;
        }
        if (cur.right != null) {
            return cur.right;
        }
        if (cur.parent != null && cur == cur.parent.left) {
            return cur.parent;
        }
        FTreeNode p = cur.parent;
        while (p != null) {
            if (cur == p.left) {
                return p;
            }
            cur = p;
            p = p.parent;
        }
        return null;
    }
}
