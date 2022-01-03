package string;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 对于两个字符串A和B，如果A和B中出现的字符种类相同且每种字符出现的次数相同，则A和B互为变形词，请设计一个高效算法，检查两给定串是否互为变形词。
 *
 * 给定两个字符串A和B及他们的长度，请返回一个bool值，代表他们是否互为变形词。
 *
 * 测试样例：
 * "abc",3,"bca",3
 * 返回：true
 */
public class Transform {

    @Test
    public void test() {
        String A = "abc";
        String B = "bca";
        boolean result = chkTransform(A, A.length(), B, B.length());
        Assert.assertTrue(result);
    }

    @Test
    public void test2() {
        String A = "abc";
        String B = "bcc";
        boolean result = chkTransform(A, A.length(), B, B.length());
        Assert.assertFalse(result);
    }

    /**
     * 方案1：HashMap 统计
     */
    public boolean chkTransform(String A, int l1, String B, int l2) {
        if (l1 != l2) {
            return false;
        }
        return buildMap(A).equals(buildMap(B));
    }

    private Map<Character, Integer> buildMap(String str) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        for (char a : chars) {
            map.merge(a, 1, Integer::sum);
        }
        return map;
    }
}
