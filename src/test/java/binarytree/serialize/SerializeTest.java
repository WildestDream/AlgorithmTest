package binarytree.serialize;

import binarytree.node.TreeNode;
import binarytree.node.TreeNodeUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * 二叉树序列化，采用前序遍历的方式
 */
public class SerializeTest {

    private TreeNode head;

    @Before
    public void init() {
        head = TreeNodeUtils.buildBTree();
    }

    public String serializeBTree(TreeNode head) {
        StringBuilder builder = new StringBuilder();
        preTraverse(head, builder);
        return builder.toString();
    }

    private void preTraverse(TreeNode cur, StringBuilder builder) {
        if (cur == null) {
            builder.append("#!");
            return;
        }
        builder.append(cur.val).append("!");
        preTraverse(cur.left, builder);
        preTraverse(cur.right, builder);
    }

    @Test
    public void test() {
        String result = serializeBTree(head);
        System.out.println(result); //1!2!4!#!#!5!#!#!3!6!#!#!7!#!#!
    }

}
