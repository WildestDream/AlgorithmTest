package sort.exercise;

import org.junit.Test;

import java.util.Arrays;

/**
 *
 * 小范围排序练习：
 *
 * 已知一个几乎有序的数组，几乎有序是指，如果把数组排好顺序的话，每个元素移动的距离可以不超过k，并且k相对于数组来说比较小。请选择一个合适的排序算法针对这个数据进行排序。
 *
 * 给定一个int数组A，同时给定A的大小n和题意中的k，请返回排序后的数组。
 *
 * 实现：改进的堆排序。or: 插入排序。
 *
 *
 * 改进后的堆排序：时间复杂度 O（N*logK）
 *
 */
public class ScaleSort {

    @Test
    public void test() {
        int[] A = {2, 1, 4, 3, 6, 5, 8, 7, 10, 9};
        int[] result = sortElement(A, A.length, 2);
        System.out.println(Arrays.toString(result));
    }

    public int[] sortElement(int[] A, int n, int k) {
        if (A == null || A.length <= 1) {
            return A;
        }
        //细节：k 比较大的时候
        k = Math.min(k, n - 1);
        int heapSize = k + 1;

        //构建一个堆
        buildHeap(A, heapSize);
        int[] result = new int[n];
        int index = 0;

        //阶段1：向堆中放一个元素，弹出一个元素，堆的大小不变
        for (int i = k + 1; i < n; i++) {
            result[index++] = A[0];
            swap(A, i, 0);
            adjustToHeap(A, heapSize, 0);
        }

        //阶段2：与阶段1类似，只不过堆的大小再逐渐的变小。
        for (int i = k; i >= 0; i--) {
            result[index++] = A[0];
            swap(A, i, 0);
            adjustToHeap(A, --heapSize, 0); //注意此时的heapSize的长度需要变化
        }
        return result;
    }

    private void buildHeap(int[] A, int len) {
        if (A == null || len <= 1) {
            return;
        }
        for (int i = len / 2 - 1; i >= 0; i--) {
            adjustToHeap(A, len, i);
        }
    }

    private void adjustToHeap(int[] A, int n, int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        if (left >= n && right >= n) {
            return;
        }
        if (right >= n) {
            if (A[left] < A[index]) {
                swap(A, index, left);
            }
            return; //这个return的位置不能放到上面 if 的里面
        }
        if (A[left] < A[right]) {
            if (A[left] < A[index]) {
                swap(A, index, left);
                adjustToHeap(A, n, left);
            }
        } else {
            if (A[right] < A[index]) {
                swap(A, index, right);
                adjustToHeap(A, n, right);
            }
        }
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
