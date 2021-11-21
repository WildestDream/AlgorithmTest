package sort.exercise;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * 求最大的K个数，利用堆排序。
 * 可以达到的时间复杂度：O(NlogK)
 */
public class TopK {

    @Test
    public void test() {
        int[] A = {3, 2, 12, 4, 3, 2, 4, 6, 12, 10};
        int[] result = topK(A, 2);
        Assert.assertArrayEquals(new int[]{12, 12}, result);
    }

    @Test
    public void test2() {
        int[] A = {3, 2, 1, 4, 3, 2, 4, 6, 12, 10};
        int[] result = topK(A, 2);
        Assert.assertArrayEquals(new int[]{10, 12}, result);
    }

    private int[] topK(int[] A, int k) {
        k = Math.min(k, A.length);
        buildHeap(A, k);
        for (int i = k; i < A.length; i++) {
            if (A[i] >= A[0]) {
                A[0] = A[i];
                adjustToHeap(A, 0, k);
            }
        }
        int[] result = new int[k];
        System.arraycopy(A, 0, result, 0, k);
        return result;
    }

    //建立小顶堆
    private void buildHeap(int[] A, int n) {
        if (A == null || n <= 1) {
            return;
        }
        for (int i = n / 2 - 1; i >= 0; i--) {
            adjustToHeap(A, i, n);
        }
    }

    private void adjustToHeap(int[] A, int index, int n) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        if (left >= n && right >= n) {
            return;
        }
        if (right >= n) {
            if (A[left] < A[index]) {
                swap(A, left, index);
            }
            return;
        }
        if (A[left] < A[right]) {
            if (A[left] < A[index]) {
                swap(A, left, index);
                adjustToHeap(A, left, n);
            }
        } else {
            if (A[right] < A[index]) {
                swap(A, index, right);
                adjustToHeap(A, right, n);
            }
        }
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
