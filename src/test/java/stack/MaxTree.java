package stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * 对于一个没有重复元素的整数数组，请用其中元素构造一棵MaxTree，MaxTree定义为一棵二叉树，其中的节点与数组元素一一对应，
 * 同时对于MaxTree的每棵子树，它的根的元素值为子树的最大值。现有一建树方法，对于数组中的每个元素，
 * 其在树中的父亲为数组中它左边比它大的第一个数和右边比它大的第一个数中更小的一个。若两边都不存在比它大的数，那么它就是树根。
 * 请设计O(n)的算法实现这个方法。
 *
 * 给定一个无重复元素的数组A和它的大小n，请返回一个数组，其中每个元素为原数组中对应位置元素在树中的父亲节点的编号，若为根则值为-1。
 *
 * 测试样例：
 * [3,1,4,2],4
 * 返回：[2,0,-1,2]
 */
public class MaxTree {

    @Test
    public void test() {
        int[] A = {3, 1, 4, 2};
        int[] result = buildMaxTree(A, A.length);
        System.out.println(Arrays.toString(result));
        Assert.assertArrayEquals(new int[]{2, 0, -1, 2}, result);
    }

    private final Stack<Integer> stack = new Stack<>();

    public int[] buildMaxTree(int[] A, int n) {
        int[] leftRes = buildLeftFirstLargerIndexArr(A, n);
        int[] rightRes = buildRightFirstLargerIndexArr(A, n);
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            if (leftRes[i] == -1 && rightRes[i] == -1) {
                result[i] = -1;
            } else if (leftRes[i] != -1 && rightRes[i] != -1) {
                result[i] = A[leftRes[i]] < A[rightRes[i]] ? leftRes[i] : rightRes[i];
            } else {
                result[i] = leftRes[i] != -1 ? leftRes[i] : rightRes[i];
            }
        }
        return result;
    }

    public int[] buildLeftFirstLargerIndexArr(int[] A, int n) {
        int[] leftFirstLargerIndexArr = new int[n];
        int index = 0;
        for (int i = 0; i < A.length; i++) {
            if (stack.isEmpty()) {
                leftFirstLargerIndexArr[index++] = -1;
            } else {
                while (!stack.isEmpty() && A[stack.peek()] <= A[i]) {
                    stack.pop();
                }
                leftFirstLargerIndexArr[index++] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        return leftFirstLargerIndexArr;
    }

    public int[] buildRightFirstLargerIndexArr(int[] A, int n) {
        int[] rightFirstLargerIndexArr = new int[n];
        int index = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                rightFirstLargerIndexArr[index--] = -1;
            } else {
                while (!stack.isEmpty() && A[stack.peek()] <= A[i]) {
                    stack.pop();
                }
                rightFirstLargerIndexArr[index--] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        return rightFirstLargerIndexArr;
    }
}
