package sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 与冒泡相比，交换的次数较少。
 * 但是不稳定，且没有对于有序的数组，比较的次数依然很多！
 */
public class SelectionSort {

    @Test
    public void test() {

        int[] A = {4, 3, 2, 1};
        int[] result = selectionSort(A, A.length);
        System.out.println(Arrays.toString(result));
    }



    public int[] selectionSort(int[] A, int n) {
        for (int i = n - 1; i > 0; i--) {
            int maxIndex = 0;
            for (int j = 0; j <= i; j++) {
                if (A[j] > A[maxIndex]) {
                    maxIndex = j;
                }
            }
            swap(A, maxIndex, i);
        }
        return A;
    }


    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
