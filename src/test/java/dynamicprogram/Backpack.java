package dynamicprogram;

import org.junit.Assert;
import org.junit.Test;

/**
 * 一个背包有一定的承重cap，有N件物品，每件都有自己的价值，记录在数组v中，也都有自己的重量，记录在数组w中，
 * 每件物品只能选择要装入背包还是不装入背包，要求在不超过背包承重的前提下，选出物品的总价值最大。
 *
 * 给定物品的重量w价值v及物品数n和承重cap。请返回最大总价值。
 *
 * 测试样例：
 * [1,2,3],[1,2,3],3,6
 * 返回：6
 */
public class Backpack {

    @Test
    public void test() {
        int[] w = {1, 2, 3};
        int[] v = {1, 2, 3};
        int result = maxValue(w, v, 3, 6);
        Assert.assertEquals(6, result);
    }

    public int maxValue(int[] w, int[] v, int n, int cap) {
        int[][] dp = new int[n + 1][cap + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < cap + 1; j++) {
                if (w[i - 1] > j) {
                    //第i件物品超重了，肯定不放进去
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //第i件物品没有超重，在不放与放两种情况下，选择产生价值最大的情况
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i - 1]] + v[i - 1]);
                }
            }
        }
        return dp[n][cap];
    }
}
