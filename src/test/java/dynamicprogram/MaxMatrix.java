package dynamicprogram;

/**
 * 给定一个由'0'和'1'组成的2维矩阵，返回该矩阵中最大的由'1'组成的正方形的面积，输入的矩阵是字符形式而非数字形式。
 * 输入：
 * [[1,0,1,0,0],[1,0,1,1,1],[1,1,1,1,1],[1,0,0,1,0]]
 * 返回值：
 * 4
 */
public class MaxMatrix {

    /*
     dp[i][j] 代表以i,j作为右下角构成的最大正方形的边长
     */
    public int solve(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        init(matrix, dp);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return findMax(dp);
    }

    private void init(char[][] matrix, int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = matrix[i][0] - '0';
        }
        for (int j = 0; j < matrix[0].length; j++) {
            dp[0][j] = matrix[0][j] - '0';
        }
    }

    private int findMax(int[][] dp) {
        int max = dp[0][0];
        for (int[] ints : dp) {
            for (int j = 0; j < dp[0].length; j++) {
                max = Math.max(ints[j], max);
            }
        }
        return max * max;
    }
}
