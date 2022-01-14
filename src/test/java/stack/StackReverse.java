package stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * 实现一个栈的逆序，但是只能用递归函数和这个栈本身的pop操作来实现，而不能自己申请另外的数据结构。
 *
 * 给定一个整数数组A即为给定的栈，同时给定它的大小n，请返回逆序后的栈。
 *
 * 测试样例：
 * [4,3,2,1],4
 * 返回：[1,2,3,4]
 */
public class StackReverse {
    public int[] reverseStack(int[] A, int n) {
        return null; //todo 太奇怪了
    }

    @Test
    public void test() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Assert.assertArrayEquals(new Integer[]{1, 2, 3}, stack.toArray(Integer[]::new));
        reverse(stack);
        Assert.assertArrayEquals(new Integer[]{3, 2, 1}, stack.toArray(Integer[]::new));
    }

    //将栈内的所有元素反转
    private void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int bottom = getBottomNodeOut(stack);
        reverse(stack);
        stack.push(bottom);
    }

    //将栈底的元素取出来，返回
    private int getBottomNodeOut(Stack<Integer> stack) {
        Integer bottom = stack.pop();
        if (stack.isEmpty()) {
            return bottom;
        }
        int bottomNodeOut = getBottomNodeOut(stack);
        stack.push(bottom);
        return bottomNodeOut;
    }
}
