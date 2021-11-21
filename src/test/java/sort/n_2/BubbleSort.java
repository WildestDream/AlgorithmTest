package sort.n_2;

import org.junit.Test;

import java.util.Arrays;

/**
 * 思路：这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端（升序或降序排列），就如同碳酸饮料中二氧化碳的气泡最终会上浮到顶端一样，故名“冒泡排序”
 *
 * 时间复杂度：O(N²)
 *
 * 空间复杂度：O(1)
 *
 * 是否稳定：稳定
 *
 * 特点：
 * 较为适合部分有序的数组的排序
 * 相对简单
 *
 * 适合的场景：适合空间复杂度小；稳定；数据量不大；部分有序的序列的排序
 *
 * 注意事项：
 * 可以提前退出
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
