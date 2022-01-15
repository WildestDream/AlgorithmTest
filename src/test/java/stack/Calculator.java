package stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * 计算器
 */
public class Calculator {


    @Test
    public void test1() {
        int result = solve("1+2+3");
        Assert.assertEquals(6, result);
    }

    @Test
    public void test2() {
        int result = solve("3+2*3*4-1");
        Assert.assertEquals(26, result);
    }

    @Test
    public void test3() {
        int result = solve("(2 *(3 - 4))*5");
        Assert.assertEquals(-10, result);
    }

    @Test
    public void test4() {
        int result = solve("6 / 2");
        Assert.assertEquals(3, result);
    }

    @Test
    public void test5() {
        int result = solve("6 / 2 / 3");
        Assert.assertEquals(1, result);
    }

    @Test
    public void test6() {
        int result = solve("7 - (6/2/3 + 2) + 1");
        Assert.assertEquals(5, result);
    }


    private final Stack<Integer> numStack = new Stack<>();
    private final Stack<Character> operatorStack = new Stack<>();

    public int solve(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == ' ') {
                continue;
            }
            if (isNumber(c)) {
                if (numStack.isEmpty()) {
                    numStack.push(toNumber(c));
                } else {
                    if (isNumber(chars[i - 1])) {
                        numStack.push(numStack.pop() * 10 + toNumber(c));
                    } else {
                        numStack.push(toNumber(c));
                    }
                }
            } else {
                if (operatorStack.isEmpty()) {
                    operatorStack.push(c);
                } else {
                    if (c == '(') {
                        operatorStack.push(c);
                    } else if (c == ')') {
                        while (operatorStack.peek() != '(') {
                            cal();
                        }
                        operatorStack.pop();
                    } else if (c == '*') {
                        if (operatorStack.peek() == '*') {
                            cal();
                        }
                        operatorStack.push(c);
                    } else if (c == '/') {
                        if (operatorStack.peek() == '/') {
                            cal();
                        }
                        operatorStack.push(c);
                    } else if (c == '+' || c == '-') {
                        while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                            cal();
                        }
                        operatorStack.push(c);
                    } else {
                        throw new IllegalArgumentException("Operator is illegal: " + c);
                    }
                }
            }
        }

        while (!operatorStack.isEmpty()) {
            cal();
        }
        return numStack.pop();
    }

    private void cal() {
        int y = numStack.pop();
        int x = numStack.pop();
        char operator = operatorStack.pop();
        if (operator == '+') {
            numStack.push(x + y);
        } else if (operator == '-') {
            numStack.push(x - y);
        } else if (operator == '*') {
            numStack.push(x * y);
        } else if (operator == '/') {
            numStack.push(x / y);
        } else {
            throw new IllegalArgumentException("Operator is illegal: " + operator);
        }
    }

    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    private int toNumber(char c) {
        return c - '0';
    }
}
