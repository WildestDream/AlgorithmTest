package dynamicprogram;

import org.junit.Assert;
import org.junit.Test;

/**
 * 有n级台阶，一个人每次上一级或者两级，问有多少种走完n级台阶的方法。为了防止溢出，请将结果Mod 1000000007
 *
 * 给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100000。
 *
 * 测试样例：
 * 1
 * 返回：1
 *
 * 斐波那契数列
 */
public class GoUpstairs {

    @Test
    public void test() {
        Assert.assertEquals(3, countWays(3));
        Assert.assertEquals(5, countWays(4));
        Assert.assertEquals(8, countWays(5));
    }

    public int countWays(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int f1 = 1;
        int f2 = 2;
        for (int i = 3; i <= n; i++) {
            int sum = (f1 + f2) % 1000000007;
            f1 = f2;
            f2 = sum;
        }
        return f2 % 1000000007;
    }
}
