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
        Assert.assertEquals(n2, getNextNode(n4));
        Assert.assertEquals(n3, getNextNode(n6));
        Assert.assertEquals(n6, getNextNode(n1));
        Assert.assertNull(getNextNode(n7));
    }

    private FTreeNode getNextNode(FTreeNode root) {
        if (root == null) {
            return null;
        }
        //1. 右子树不为空，则后继节点是：右子树上的最左节点
        if (root.right != null) {
            return findMostLeftNode(root.right);
        }
        //2. 当前节点是父节点的左孩子，则后继节点是父节点
        if (root.parent != null && root == root.parent.left) {
            return root.parent;
        }
        //3. 当前节点是父节点的右孩子，则一直向上寻找，直到s 是 p 的左孩子为止，返回 p
        FTreeNode s = root;
        FTreeNode p = root.parent;
        while (p != null) {
            if (s == p.left) {
                return p;
            }
            s = s.parent;
            p = p.parent;
        }
        //4. 直到p为空，s 都不是 p 的左孩子，当前节点不存在后继节点，返回 null。
        return null;
    }

    private FTreeNode findMostLeftNode(FTreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
