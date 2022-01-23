package dynamicprogram;

import java.util.Arrays;

/**
 * 对于两个字符串A和B，我们需要进行插入、删除和修改操作将A串变为B串，定义c0，c1，c2分别为三种操作的代价，请设计一个高效算法，求出将A串变为B串所需要的最少代价。
 *
 * 给定两个字符串A和B，及它们的长度和三种操作代价，请返回将A串变为B串所需要的最小代价。保证两串长度均小于等于300，且三种代价值均小于等于100。
 *
 * 测试样例：
 * "abc",3,"adc",3,5,3,100
 * 返回：8
 */
public class EditMinCost {
    public int findMinCost(String A, int n, String B, int m, int c0, int c1, int c2) {
        int[][] dp = new int[n + 1][m + 1];
        initFirstLine(dp, c0);
        initFirstColumn(dp, c1);
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = findMin(
                            dp[i - 1][j] + c1,
                            dp[i][j - 1] + c0,
                            dp[i - 1][j - 1] + c0 + c1,
                            dp[i - 1][j - 1] + c2);
                }
            }
        }
        return dp[n][m];
    }

    private void initFirstLine(int[][] dp, int c0) {
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = j * c0;
        }
    }

    private void initFirstColumn(int[][] dp, int c1) {
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i * c1;
        }
    }

    private int findMin(int... args) {
        return Arrays.stream(args).min().orElse(-1);
    }
}
