package string;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 对于一个字符串,请设计一个高效算法，找到字符串的最长无重复字符的子串长度。
 *
 * 给定一个字符串A及它的长度n，请返回它的最长无重复字符子串长度。保证A中字符全部为小写英文字符，且长度小于等于500。
 *
 * 测试样例：
 * "aabcb",5
 * 返回：3
 */
public class DistinctSubstring {

    @Test
    public void test() {
        String str = "abc";
        int max = longestSubstring(str, str.length());
        Assert.assertEquals(3, max);
    }

    @Test
    public void test2() {
        String str = "abca";
        int max = longestSubstring(str, str.length());
        Assert.assertEquals(3, max);
    }

    @Test
    public void test3() {
        String str = "abcabbb";
        int max = longestSubstring(str, str.length());
        Assert.assertEquals(3, max);
    }

    public int longestSubstring(String A, int n) {
        if (A == null || A.length() == 0) {
            return 0;
        }
        if (A.length() == 1) {
            return 1;
        }
        //以每个字符结尾，向左的最长无重复子串的长度
        int[] maxs = new int[A.length()];
        //每个字符上一次出现的位置
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = A.toCharArray();
        //第一个字符特殊处理
        maxs[0] = 1;
        map.put(chars[0], 0);
        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            //计算每一个字符到上一次该字符出现的距离
            int len = map.containsKey(c) ? i - map.get(c) : i + 1;
            if (len > maxs[i - 1]) {
                maxs[i] = maxs[i - 1] + 1;
            } else {
                maxs[i] = len;
            }
            map.put(c, i);
        }
        return findMax(maxs);
    }

    private int findMax(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}
