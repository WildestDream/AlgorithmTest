package binarytree.serialize;

import binarytree.node.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 二叉树返序列化（前序）
 */
public class DeSerializeTest {

    @Test
    public void deSerialize() {
        String bTreeStr = "1!2!4!#!#!5!#!#!3!6!#!#!7!#!#!";
        TreeNode treeNode = deSerialize(bTreeStr);
        Assert.assertEquals(bTreeStr, new SerializeTest().serializeBTree(treeNode));
    }

    private TreeNode deSerialize(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        String[] nodes = str.split("!");
        return deSerialize(nodes);
    }

    private int index = 0;

    private TreeNode deSerialize(String[] nodes) {
        if (nodes[index].equals("#")) {
            index++;
            return null;
        }
        int val = Integer.parseInt(nodes[index]);
        TreeNode curNode = new TreeNode(val);
        index++;
        curNode.left = deSerialize(nodes); //属性index被修改
        curNode.right = deSerialize(nodes);
        return curNode;
    }
}
