package sort.log2_n;

import java.util.ArrayList;
import java.util.List;

/**
 * 现在有一个行和列都排好序的矩阵，请设计一个高效算法，快速查找矩阵中是否含有值x。
 *
 * 给定一个int矩阵mat，同时给定矩阵大小nxm及待查找的数x，请返回一个bool值，代表矩阵中是否存在x。所有矩阵中数字及x均为int范围内整数。保证n和m均小于等于1000。
 *
 * 测试样例：
 * [[1,2,3],[4,5,6],[7,8,9]],3,3,10
 * 返回：false
 *
 *
 */
public class Finder {
    public boolean findX(int[][] mat, int n, int m, int x) {
        if (n <= 0 || m <= 0) {
            return false;
        }
        if (n == 1 && m == 1) {
            return mat[0][0] == x;
        }
        //所有可能出现的行
        List<Integer> proXs = new ArrayList<>();
        //所有可能出现的列
        List<Integer> proYs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (x >= mat[i][0] && x <= mat[i][m - 1]) {
                proXs.add(i);
            }
        }
        for (int j = 0; j < m; j++) {
            if (x >= mat[0][j] && x <= mat[n - 1][j]) {
                proYs.add(j);
            }
        }

        for (Integer x1 : proXs) {
            for (Integer y1 : proYs) {
                if (mat[x1][y1] == x) {
                    return true;
                }
            }
        }
        return false;
    }
}
