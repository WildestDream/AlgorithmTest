package sort.exercise;

/**
 * 有两个从小到大排序以后的数组A和B，其中A的末端有足够的缓冲空容纳B。请编写一个方法，将B合并入A并排序。
 *
 * 给定两个有序int数组A和B，A中的缓冲空用0填充，同时给定A和B的真实大小int n和int m，请返回合并后的数组。
 *
 * 思路：其实是考察归并排序的合并部分
 */
public class MergeAB {
    public int[] mergeAB(int[] A, int[] B, int n, int m) {
        if (B == null || m == 0) {
            return A;
        }
        if (A == null || n == 0) {
            return B;
        }
        int i = n - 1;
        int j = m - 1;
        int index = n + m - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) {
                A[index--] = A[i--];
            } else {
                A[index--] = B[j--];
            }
        }
        if (j >= 0) {
            System.arraycopy(B, 0, A, 0, j + 1);
        }
        return A;
    }
}
