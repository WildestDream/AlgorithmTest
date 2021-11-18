package sort.n_2;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * 插入排序 稳定
 * 比较适合部分有序数组的排序
 */
public class InsertionSort {

    @Test
    public void test() {
        int[] A = {4, 3, 2, 1};
        int[] result = insertionSort(A, A.length);
        System.out.println(Arrays.toString(result));
    }

    /**
     * 1千万条数据，duration: 5.39h
     */
    @Test
    public void testPerf() {
        Random random = new Random();
        int num = 100_0000;
        int[] A = new int[num];
        for (int i = 0; i < num; i++) {
            A[i] = random.nextInt(1000000);
        }
        long start = System.currentTimeMillis();
        insertionSort(A, A.length);
        long end = System.currentTimeMillis();
        System.out.println("duration:" + (end - start) + " ms");//duration:18589 ms
    }

    public int[] insertionSort(int[] A, int n) {
        if (A == null || A.length <= 1) {
            return A;
        }
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (A[j] < A[j - 1]) {
                    swap(A, j, j - 1);
                } else {
                    break;
                }
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
