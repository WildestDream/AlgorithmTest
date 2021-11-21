package sort.N_2;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * 思路：它的基本思想是将一个记录插入到已经排好序的有序表中，从而一个新的、记录数增1的有序表。类似：排序一手扑克牌
 *
 * 时间复杂度：O(N²)
 *
 * 空间复杂度：O(1)
 *
 * 是否稳定：稳定
 *
 * 特点：
 * 适合部分有序的数列的排序。
 * 相对简单
 *
 * 适合的场景：适合空间复杂度小；数据量不大的场景，稳定，部分有序。
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
