package dynamicprogram;

import org.junit.Assert;
import org.junit.Test;

/**
 * 最大回文子串
 *
 * 输入：
 * "ababc"
 *
 * 返回值：
 * 3
 *
 * 说明：
 * 最长的回文子串为"aba"与"bab"，长度都为3
 */
public class LongestPalindrome {

    @Test
    public void test() {
        int result = getLongestPalindrome("bab");
        Assert.assertEquals(3, result);
    }

    @Test
    public void test2() {
        int result = getLongestPalindrome("baabccc");
        Assert.assertEquals(4, result);
    }

    public int getLongestPalindrome(String A) {
        if (A == null || A.isEmpty()) {
            return 0;
        }
        int[][] dp = new int[A.length()][A.length()];
        for (int j = 0; j < A.length(); j++) {
            int x = 0;
            int y = j;
            while (x < A.length() && y < A.length()) {
                if (A.charAt(x) != A.charAt(y)) {
                    dp[x][y] = 0; //0 代表 [x,y] 不是回文子串
                } else {
                    if (x == y) {
                        dp[x][y] = 1;
                    } else if (y - x == 1) {
                        dp[x][y] = 2;
                    } else {
                        dp[x][y] = dp[x + 1][y - 1] == 0 ? 0 : dp[x + 1][y - 1] + 2;
                    }
                }
                x++;
                y++;
            }
        }
        return findMax(dp);
    }

    private int findMax(int[][] dp) {
        int max = 1;
        for (int[] line : dp) {
            for (int len : line) {
                max = Math.max(max, len);
            }
        }
        return max;
    }
}
