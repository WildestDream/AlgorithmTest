package stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * 将一个栈从栈顶到栈底，从大到小排序
 * 要求：
 * 1. 只能额外申请一个栈
 * 2. 不允许再申请其他的数据结构
 */
public class TwoStackSort {

    @Test
    public void test() {
        int[] numbers = {2, 3, 1, 4, 5};
        ArrayList<Integer> result = twoStacksSort(numbers);
        Assert.assertEquals(Arrays.asList(5, 4, 3, 2, 1), result);
    }

    public ArrayList<Integer> twoStacksSort(int[] numbers) {
        Stack<Integer> store = new Stack<>();
        for (int number : numbers) {
            store.push(number);
        }
        Stack<Integer> sorted = new Stack<>();
        sortByTwoStack(store, sorted);
        ArrayList<Integer> result = new ArrayList<>();
        while (!sorted.isEmpty()) {
            result.add(sorted.pop());
        }
        return result;
    }

    private void sortByTwoStack(Stack<Integer> store, Stack<Integer> sorted) {
        while (!store.isEmpty()) {
            Integer curVal = store.pop();
            if (!sorted.isEmpty() && curVal < sorted.peek()) {
                while (!sorted.isEmpty() && sorted.peek() > curVal) {
                    store.push(sorted.pop());
                }
            }
            sorted.push(curVal);
        }
    }

}
