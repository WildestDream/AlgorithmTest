package string;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 对于一个给定的字符串数组，请找到一种拼接顺序，使所有小字符串拼接成的大字符串是所有可能的拼接中字典序最小的。
 *
 * 给定一个字符串数组strs，同时给定它的大小，请返回拼接成的串。
 *
 * 测试样例：
 * ["abc","de"],2
 * "abcde"
 */
public class Prior {

    @Test
    public void test() {
        String[] arr = {"abc", "de"};
        Assert.assertEquals("abcde", findSmallest(arr, arr.length));
    }

    public String findSmallest(String[] arr, int n) {
        if (arr == null || n == 0) {
            return null;
        }
        Arrays.sort(arr, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        return buildResult(arr);
    }

    private String buildResult(String[] arr) {
        StringBuilder builder = new StringBuilder();
        for (String s : arr) {
            builder.append(s);
        }
        return builder.toString();
    }
}
