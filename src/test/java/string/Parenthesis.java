package string;

import org.junit.Assert;
import org.junit.Test;

/**
 * 对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。
 *
 * 给定一个字符串A和它的长度n，请返回一个bool值代表它是否为一个合法的括号串。
 *
 * 测试样例：
 * "(()())",6
 * 返回：true
 * 测试样例：
 * "()a()()",7
 * 返回：false
 * 测试样例：
 * "()(()()",7
 * 返回：false
 */
public class Parenthesis {

    @Test
    public void test1() {
        Assert.assertTrue(chkParenthesis("(()())", 6));
        Assert.assertFalse(chkParenthesis("()a()()", 7));
        Assert.assertFalse(chkParenthesis("()(()()", 7));
    }

    public boolean chkParenthesis(String A, int n) {
        int cnt = 0;
        char[] chars = A.toCharArray();
        for (char c : chars) {
            if (c == '(') {
                cnt++;
            } else if (c == ')') {
                cnt--;
            } else if (cnt <= 0) {
                return false;
            }
            if (cnt < 0) {
                return false;
            }
        }
        return cnt == 0;
    }
}
