package search;

import org.junit.Assert;
import org.junit.Test;

/**
 * 如果更快的求一个整数k的n次方。如果两个整数相乘并得到结果的时间复杂度为O(1)，得到整数k的N次方的过程请实现时间复杂度为O(logN)的方法。
 *
 * 给定k和n，请返回k的n次方，为了防止溢出，请返回结果Mod 1000000007的值。
 *
 * 测试样例：
 * 2,3
 * 返回：8
 */
public class QuickPower {

    @Test
    public void test() {
        Assert.assertEquals(1, getPower(2, 0));
        Assert.assertEquals(2, getPower(2, 1));
        Assert.assertEquals(32, getPower(2, 5));
        Assert.assertEquals(100000, getPower(10, 5));
        Assert.assertEquals(1024, getPower(2, 10));
    }

    public int getPower(int k, int N) {
        int res = 1;
        String binaryN = Integer.toBinaryString(N);
        for (int i = binaryN.length() - 1; i >= 0; i--) {
            int v = Integer.parseInt(binaryN.charAt(i) + "");
            if (v == 1) {
                res *= k;
            }
            k *= k;
        }
        return res;
    }

    //mod 版本
    public int getPowerMod(int k, int N) {
        long res = 1;
        long K = k;
        String binaryN = Integer.toBinaryString(N);
        for (int i = binaryN.length() - 1; i >= 0; i--) {
            int v = Integer.parseInt(binaryN.charAt(i) + "");
            if (v == 1) {
                res = (res * K) % 1000000007;
            }
            K = (K * K) % 1000000007;
        }
        return (int) res % 1000000007;
    }

    @Test
    public void test2() {
        Assert.assertEquals(Integer.toBinaryString(75), getBinarySting(75));
        Assert.assertEquals(Integer.toBinaryString(1234567), getBinarySting(1234567));
    }

    //小测试：获取一个整数的二进制串
    private String getBinarySting(int num) {
        StringBuilder str = new StringBuilder();
        while (num > 0) {
            str.insert(0, num % 2);
            num /= 2;
        }
        return str.toString();
    }
}
