package sort.log2_n;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * 归并排序：
 */
public class MergeSort {

    @Test
    public void test() {
        int[] A = {3, 2, 1, 4, 2, 2};
        int[] result = mergeSort(A, A.length);
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testPerf() {
        Random random = new Random();
        int num = 1_0000_0000;
        int[] A = new int[num];
        for (int i = 0; i < num; i++) {
            A[i] = random.nextInt(1000000);
        }
        long start = System.currentTimeMillis();
        mergeSort(A, A.length);
        long end = System.currentTimeMillis();
        System.out.println("duration:" + (end - start) + " ms");//duration:18589 ms
    }

    public int[] mergeSort(int[] A, int n) {
        sort(A, 0, A.length - 1);
        return A;
    }

    /**
     * 对数组A从start到end位置区域排序
     */
    private void sort(int[] A, int start, int end) {
        //只有一个数据，直接返回
        if (start == end) {
            return;
        }
        int middle = start + (end - start) / 2;
        sort(A, start, middle);
        sort(A, middle + 1, end);
        merge(A, start, middle, end);
    }

    /**
     * 对于数组A，start ~ middle，middle+1 ~ end 是两个有序的数组，
     * 把他们合并成为一个在 start - end 连续的数组。
     * 注意：是修改A，并不是返回新的数组
     */
    private void merge(int[] A, int start, int middle, int end) {
        int i = start;
        int j = middle + 1;
        int len = end - start + 1;
        int index = 0;
        int[] helper = new int[len]; //辅助的数组
        while (i <= middle && j <= end) {
            if (A[i] < A[j]) {
                helper[index++] = A[i++];
            } else {
                helper[index++] = A[j++];
            }
        }
        if (i <= middle) {
            System.arraycopy(A, i, helper, index, middle - i + 1);
        } else if (j <= end) {
            System.arraycopy(A, j, helper, index, end - j + 1);
        }
        System.arraycopy(helper, 0, A, start, len); //最后记得重新写回A
    }
}
