package dynamicprogram;

import org.junit.Assert;
import org.junit.Test;

/**
 * 有数组penny，penny中所有的值都为正数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，
 * 再给定一个整数aim(小于等于1000)代表要找的钱数，求换钱有多少种方法。
 *
 * 给定数组penny及它的大小(小于等于50)，同时给定一个整数aim，请返回有多少种方法可以凑成aim。
 *
 * 测试样例：
 * [1,2,4],3,3
 * 返回：2
 */
public class Exchange {

    @Test
    public void test() {
        int result = countWays(new int[]{1, 2, 4}, 3, 3);
        Assert.assertEquals(2, result);
    }

    @Test
    public void test2() {
        int result = countWays(new int[]{1, 4, 5, 8, 10}, 5, 5);
        Assert.assertEquals(3, result);
    }

    public int countWays(int[] penny, int n, int aim) {
        if (n <= 0 || aim < 0) {
            return 0;
        }
        //arr[i][j] 代表 使用arr[0~i]的面值凑出j元的方法数，则 arr的右下角就是最终要求的值
        int[][] arr = new int[penny.length][aim + 1];
        //初始化矩阵第一行
        initFirstLine(arr, penny[0]);
        //初始化矩阵第一列
        initFirstColumn(arr);
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < aim + 1; j++) {
                if (penny[i] > j) {
                    //情况1：penny[i]的面值大于j，则penny[i]一定不会参与目标j的凑数
                    arr[i][j] = arr[i - 1][j];
                } else {
                    //情况2：penny[i]的面值小于等于j，则arr[i][j] = penny[i]不参与凑数 + penny[i] 参数凑数 的两种情况的方法数之和。
                    arr[i][j] = arr[i - 1][j] + arr[i][j - penny[i]];
                }
            }
        }
        return arr[penny.length - 1][aim];
    }

    private void initFirstLine(int[][] arr, int firstMoney) {
        int[] firstLine = arr[0];
        for (int j = 1; j < firstLine.length; j++) {
            if (j % firstMoney == 0) {
                firstLine[j] = 1;
            }
        }
    }

    private void initFirstColumn(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = 1;
        }
    }
}
