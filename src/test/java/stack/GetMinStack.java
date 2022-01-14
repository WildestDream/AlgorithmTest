package stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */
public class GetMinStack {

    @Test
    public void test() {
        GetMinStack stack = new GetMinStack();
        stack.push(5);
        stack.push(2);
        stack.push(5);
        stack.push(1);
        int min = stack.min();
        Assert.assertEquals(1, min);
        stack.pop();
        min = stack.min();
        Assert.assertEquals(2, min);
        stack.pop();
        min = stack.min();
        Assert.assertEquals(2, min);
        stack.pop();
        min = stack.min();
        Assert.assertEquals(5, min);
    }

    private final Stack<Integer> stackStore = new Stack<>();
    private final Stack<Integer> stackMin = new Stack<>();

    public void push(int node) {
        stackStore.push(node);
        if (stackMin.isEmpty()) {
            stackMin.push(node);
        } else {
            Integer lastNode = stackMin.peek();
            if (node <= lastNode) {
                stackMin.push(node);
            } else {
                stackMin.push(lastNode);
            }
        }
    }

    public int pop() {
        stackMin.pop();
        return stackStore.pop();
    }

    public int top() {
        return stackStore.peek();
    }

    public int min() {
        return stackMin.peek();
    }
}
