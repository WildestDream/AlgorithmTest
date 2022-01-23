package dynamicprogram;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定两个字符串A和B，返回两个字符串的最长公共子序列的长度。例如，A="1A2C3D4B56”，B="B1D23CA45B6A”，”123456"或者"12C4B6"都是最长公共子序列。
 *
 * 给定两个字符串A和B，同时给定两个串的长度n和m，请返回最长公共子序列的长度。保证两串长度均小于等于300。
 *
 * 测试样例：
 * "1A2C3D4B56",10,"B1D23CA45B6A",12
 * 返回：6
 *
 * 方法2： 不需要特殊初始化第一行、第一列。
 *
 * 可以看做在A,B的两个字符串的开头各放了一个特殊字符进行比较且绝对不会重复，这样第一行、第一列都是0，
 * 例如：1A2C3D4B56 与 B1D23CA45B6A 可以转化成：
 *      ＞1A2C3D4B56  与 ＜B1D23CA45B6A 的求解
 */
public class LCS2 {

    @Test
    public void test() {
        int result = findLCS("1A2C3D4B56", 10, "B1D23CA45B6A", 12);
        Assert.assertEquals(6, result);
    }

    public int findLCS(String A, int n, String B, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }
}
