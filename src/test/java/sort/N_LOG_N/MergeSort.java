package sort.N_LOG_N;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * 思路：归并排序（MERGE-SORT）是利用归并的思想实现的排序方法，该算法采用经典的分治（divide-and-conquer）策略（分治法将问题分(divide)成一些小的问题然后递归求解，而治(conquer)的阶段则将分的阶段得到的各答案"修补"在一起，即分而治之)。
 * 具体：找到中点，将中点左侧的元素排序，再将中点右侧的元素排序，再将两个有序的序列合并。
 *
 *
 *
 * 时间复杂度：n*logn  （总的时间复杂度是：logN（划分部分） + NlogN（合并部分），忽略了logN）
 *
 * 空间复杂度：O(n)
 * 【注】递归代码的空间复杂度并不能像时间复杂度那样累加。尽管每次合并操作都需要申请额外的内存空间，但在合并完成之后，临时开辟的内存空间就被释放掉了。在任意时刻，CPU 只会有一个函数在执行，也就只会有一个临时的内存空间在使用。临时内存空间最大也不会超过 n 个数据的大小，所以空间复杂度是 O(n)
 *
 *
 *
 * 是否稳定：稳定
 *
 * 特点：
 * 在合并的时候需要申请额外的辅助空间，空间复杂度为 O（N），这是很大的一个弊端。这一点快速排序可以很好的克服。
 *
 * 适合的场景：数据量大；要求稳定；
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
