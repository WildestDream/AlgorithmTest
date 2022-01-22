package dynamicprogram;

import org.junit.Assert;
import org.junit.Test;

/**
 * 这是一个经典的LIS(即最长上升子序列)问题，请设计一个尽量优的解法求出序列的最长上升子序列的长度。
 *
 * 给定一个序列A及它的长度n(长度小于等于500)，请返回LIS的长度。
 *
 * 测试样例：
 * [1,4,2,5,3],5
 * 返回：3
 */
public class LIS {

    @Test
    public void test() {
        int[] A = {1, 4, 2, 5, 3};
        Assert.assertEquals(3, getLIS(A, A.length));
    }

    public int getLIS(int[] A, int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int max = -1;
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    max = Math.max(dp[j], max);
                }
            }
            dp[i] = max == -1 ? 1 : max + 1;
        }
        return findMax(dp);
    }

    private int findMax(int[] dp) {
        int max = -1;
        for (int i : dp) {
            max = Math.max(i, max);
        }
        return max;
    }
}
