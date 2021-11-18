package sort.log2_n;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序，分治算法
 * 过程中不需要创建辅助的数据结构
 */
public class QuickSort {

    @Test
    public void test1() {
        int[] A = {54, 35, 48, 36, 27, 12, 44, 44, 8, 14, 26, 17, 28};
        int[] result = quickSort(A, A.length);
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
        quickSort(A, A.length);
        long end = System.currentTimeMillis();
        System.out.println("duration:" + (end - start) + " ms");//duration:18433 ms
    }

    public int[] quickSort(int[] A, int n) {
        if (A == null || A.length <= 1) {
            return A;
        }
        sort(A, 0, A.length - 1);
        return A;
    }

    private void sort(int[] A, int start, int end) {
        //写 ≥ 更加的安全，而不要写 =
        if (start >= end) {
            return;
        }
        int middle = start + (end - start) / 2;
        //将随机选中的一个数与最右边的数交换
        swap(A, middle, end);
        //对于数组A（最右边放的是基准值），将数组按照基准值分区，小于的基准值的放到左边，大于基准值的放到右边，最后返回基准值所在的位置
        int pivot = partition(A, start, end);
        //分别对左右两个分区排序即可
        sort(A, start, pivot - 1);
        sort(A, pivot + 1, end);
    }

    //这个过程并不需要创建额外的辅助数组，例如 归并排序的 helper
    private int partition(int[] A, int start, int end) {
        int pivot = start - 1; //左分区的最后一个数的位置
        int index = start;
        while (index <= end) {
            if (A[index] <= A[end]) { //最后一个数一定会触发 = 的情况
                swap(A, ++pivot, index); //++pivot位置的数是右分区的第一个数字，一定大于基准值，所以与它交换
            }
            index++;
        }
        return pivot;
    }

    private void swap(int[] A, int index1, int index2) {
        if (index1 != index2) {
            int temp = A[index1];
            A[index1] = A[index2];
            A[index2] = temp;
        }
    }
}
