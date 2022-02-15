package sort.N_LOG_N;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * 堆的概念：
 *  1. 堆是一个完全二叉树(并不一定满) 且
 *  2. 堆一定满足：A[i] >= A[2i + 1] && A[i] >= A[2i + 2] （大顶堆）
 *
 * 思路：
 * 建立一个堆
 * 将堆顶元素（最大值）与最后一个元素调换
 * 将剩下的结构（左、右子树都是堆，但是堆顶不一定是最大值了）再调整成为一个堆
 * 注意：一个满二叉树最后一个非叶子节点的下标：arr.length / 2 - 1
 *
 * 时间复杂度:  nlogn
 *
 * 空间复杂度:  O(1)
 *
 * 稳定性：不稳定
 *
 * 特点：
 *
 * 适合的场景：
 *
 * 场景1：
 * 优先级队列：
 *        一个堆就可以看做是一个优先级队列。
 *      插入：向堆的最后插入元素，重新调成成为堆。
 *      取出：弹出堆顶元素即可
 *
 * 场景2：
 * topK：
 * （1）将原始的K个数先构造成为一个小顶堆（用这个堆维护前k个最大值）
 * （2）从 k + 1 个数开始遍历，若小于等于堆顶元素，直接跳过
 * （3）大于堆顶元素，替换堆顶元素，将剩下的结构重新调整成为一个新的堆。
 */
public class HeapSort {

    @Test
    public void test() {
        int[] A = new int[10];
        Random random = new Random();
        for (int i = 0; i < A.length; i++) {
            A[i] = random.nextInt(100);
        }
        heapSort(A);
        System.out.println(Arrays.toString(A));
    }

    /**
     * 主入口
     * @param A
     */
    private void heapSort(int[] A) {
        if (A == null || A.length == 1) {
            return;
        }
        buildHeap(A);
        int len = A.length;
        for (int i = A.length - 1; i > 0; i--) {
            swap(A, 0, i);
            adjust(A, 0, --len);
        }
    }

    /**
     * 建堆
     * @param A
     */
    private void buildHeap(int[] A) {
        int lastNonLeafNode = A.length / 2 - 1;
        //构建的顺序：从最后一个非叶子节点开始，从右向左，从下层向上层
        for (int i = lastNonLeafNode; i >= 0; i--) {
            adjust(A, i, A.length);
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
            if (A[index] < A[left]) {
                swap(A, index, left);
                adjust(A, left, len);
            }
            return;
        }
        if (A[left] > A[right]) {
            if (A[index] < A[left]) {
                swap(A, index, left);
                adjust(A, left, len);
            }
        } else {
            if (A[index] < A[right]) {
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
