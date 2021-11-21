package sort.n_2;

import org.junit.Test;

import java.util.Arrays;

/**
 * 思路：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
 *
 * 时间复杂度：O(N²)
 *
 * 空间复杂度：O(1)
 *
 * 是否稳定：不稳定。例如：2 1 1， 排序后 1 1 2 这两个1的顺序已经颠倒
 *
 * 特点：
 * 最多swap N - 1次，大多数都是基于compare的操作，一般认为compare操作比swap操作堆CPU的压力更小，因此在N较小的时候，选择排序比冒泡有着更好的性能
 * 相对简单
 *
 * 适合的场景：适合空间复杂度小；数据量不大的场景，且堆稳定性没有要求。
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
