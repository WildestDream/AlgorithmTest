package stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class ParenthesesCheck {

    @Test
    public void test1() {
        Assert.assertTrue(isValid("()[]{}"));
    }

    @Test
    public void test2() {
        Assert.assertTrue(isValid("[()]{}"));
    }

    @Test
    public void test3() {
        Assert.assertFalse(isValid("[{]]"));
    }

    @Test
    public void test4() {
        Assert.assertFalse(isValid("{{]}}}"));
    }

    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        if (s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char pre = stack.pop();
                if (c == ')' && pre != '(') {
                    return false;
                }
                if (c == ']' && pre != '[') {
                    return false;
                }
                if (c == '}' && pre != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
