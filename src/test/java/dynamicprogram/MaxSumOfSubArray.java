package dynamicprogram;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 *
 * 子数据的最大和
 *
 * 输入一个长度为n的整型数组array，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 数据范围:
 * 1 <= n <= 2\times10^51<=n<=2×10
 * 5
 *
 * -100 <= a[i] <= 100−100<=a[i]<=100
 *
 * 要求:时间复杂度为 O(n)O(n)，空间复杂度为 O(n)O(n)
 * 进阶:时间复杂度为 O(n)O(n)，空间复杂度为 O(1)O(1)
 *
 * 输入：
 * [1,-2,3,10,-4,7,2,-5]
 *
 * 返回值：
 * 18
 *
 * 说明：
 * 经分析可知，输入数组的子数组[3,10,-4,7,2]可以求得最大和为18
 */
public class MaxSumOfSubArray {

    @Test
    public void test() {
        int[] arr = {1, -2, 3, 10, -4, 7, 2, -5};
        int result = FindGreatestSumOfSubArray(arr);
        Assert.assertEquals(18, result);
    }

    public int FindGreatestSumOfSubArray(int[] array) {
        int[] dp = new int[array.length];
        dp[0] = array[0];
        for (int i = 1; i < dp.length; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = array[i];
            } else {
                dp[i] = dp[i - 1] + array[i];
            }
        }
        return findMax(dp);
    }

    private int findMax(int[] dp) {
        return Arrays.stream(dp).max().orElse(-1);
    }
}
