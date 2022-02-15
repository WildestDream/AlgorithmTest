package sort.N_LOG_N;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * 利用堆排序实现 TopK
 *  (1）将原始的K个数先构造成为一个小顶堆（用这个堆维护前k个最大值）
 * （2）从 k + 1 个数开始遍历，若小于等于堆顶元素，直接跳过
 * （3）大于堆顶元素，替换堆顶元素，将剩下的结构重新调整成为一个新的堆。
 */
public class TopK {

    @Test
    public void test2() {
        int[] A = {1, 2, 3, 4, 5, 6, 7};
        int[] res = Arrays.copyOfRange(A, 0, 2);
        System.out.println(Arrays.toString(res));
        System.out.println(Arrays.toString(A));
    }

    @Test
    public void test() {
        int[] A = new int[10];
        Random random = new Random();
        for (int i = 0; i < A.length; i++) {
            A[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(A));
        int[] result = topK(A, 3);
        System.out.println(Arrays.toString(result));
    }

    private int[] topK(int[] A, int K) {
        if (A.length <= K) {
            return A;
        }
        //构建小顶堆
        buildHeap(A, K);
        for (int i = K; i < A.length; i++) {
            if (A[i] > A[0]) {
                swap(A, i, 0);
                adjust(A, 0, K);
            }
        }
        return Arrays.copyOfRange(A, 0, K);
    }

    /**
     * 建堆
     * @param A
     */
    private void buildHeap(int[] A, int len) {
        int lastNonLeafNode = len / 2 - 1;
        //构建的顺序：从最后一个非叶子节点开始，从右向左，从下层向上层
        for (int i = lastNonLeafNode; i >= 0; i--) {
            adjust(A, i, len);
        }
    }

    /**
     * 堆中index头节点下，两个左右子树都已经是堆结构了（这个前提必须满足）
     * 将以index为头节点的整体调整为一个堆结构
     */
    private void adjust(int[] A, int index, int len) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        if (left >= len && right >= len) {
            return;
        }
        if (right >= len) {
            if (A[index] > A[left]) {
                swap(A, index, left);
                adjust(A, left, len);
            }
            return;
        }
        if (A[left] < A[right]) {
            if (A[index] > A[left]) {
                swap(A, index, left);
                adjust(A, left, len);
            }
        } else {
            if (A[index] > A[right]) {
                swap(A, index, right);
                adjust(A, right, len);
            }
        }
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
