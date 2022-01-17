package binarytree.list;

/**
 * 实现一个算法，删除单向链表中间的某个结点，假定你只能访问该结点。
 * 删除单个节点
 */
public class DelNode {
    public boolean removeNode(ListNode pNode) {
        if (pNode == null) {
            return false;
        }
        ListNode next = pNode.next;
        if (next == null) {
            return false;
        }
        pNode.val = next.val;
        pNode.next = next.next;
        return true;
    }
}
