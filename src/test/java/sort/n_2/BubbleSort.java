package sort.n_2;

import org.junit.Test;

import java.util.Arrays;

/**
 * 冒泡
 *
 * 稳定
 * 可以提前退出，适合部分有序的数组的排序
 */
public class BubbleSort {

    @Test
    public void test() {
        int[] A = {4, 3, 2, 1};
        int[] res = bubbleSort(A, A.length);
        System.out.println(Arrays.toString(res));
    }

    public int[] bubbleSort(int[] A, int n) {
        if (A == null || A.length <= 1) {
            return A;
        }
        for (int i = n - 2; i >= 0; i--) {
            boolean exchange = false;
            for (int j = 0; j <= i; j++) {
                if (A[j] > A[j + 1]) {
                    swap(A, j, j + 1);
                    exchange = true;
                }
            }
            if (!exchange) {
                System.out.println("提前退出！");
                return A;
            }
        }
        return A;
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
