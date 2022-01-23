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
 */
public class LCS {

    @Test
    public void test() {
        int result = findLCS("1A2C3D4B56", 10, "B1D23CA45B6A", 12);
        Assert.assertEquals(6, result);
    }

    public int findLCS(String A, int n, String B, int m) {
        char[] arr1 = A.toCharArray();
        char[] arr2 = B.toCharArray();
        int[][] dp = new int[n][m];

        initFirstLine(dp, arr2, arr1[0]);
        initFirstColumn(dp, arr1, arr2[0]);

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (arr1[i] == arr2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n - 1][m - 1];
    }

    private void initFirstLine(int[][] dp, char[] arr, char c) {
        boolean flag = false;
        for (int j = 0; j < dp[0].length; j++) {
            if (!flag && arr[j] == c) {
                dp[0][j] = 1;
                flag = true;
            } else if (flag) {
                dp[0][j] = 1;
            }
        }
    }

    private void initFirstColumn(int[][] dp, char[] arr, char c) {
        boolean flag = false;
        for (int i = 0; i < dp.length; i++) {
            if (!flag && arr[i] == c) {
                dp[i][0] = 1;
                flag = true;
            } else if (flag) {
                dp[i][0] = 1;
            }
        }
    }
}
