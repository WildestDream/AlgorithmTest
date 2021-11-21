package sort.N_LOG_N;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * 堆的概念：
 *  1. 堆是一个完全二叉树 且
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
 * 优先级队列：
 *        一个堆就可以看做是一个优先级队列。
 *      插入：向堆的最后插入元素，重新调成成为堆。
 *      取出：弹出堆顶元素即可
 *
 * topK：
 * （1）将原始的K个数先构造成为一个小顶堆（用这个堆维护前k个最大值）
 * （2）从 k + 1 个数开始遍历，若小于等于堆顶元素，直接跳过
 * （3）大于堆顶元素，替换堆顶元素，将剩下的结构重新调整成为一个新的堆。
 */
public class HeapSort {

    @Test
    public void test() {
        int num = 10;
        Random random = new Random();
        int[] A = new int[num];
        for (int i = 0; i < num; i++) {
            A[i] = random.nextInt(20);
        }
        createHeap(A);
        heapSort(A, A.length);
        System.out.println(Arrays.toString(A));
    }

    @Test
    public void testPerf() {
        Random random = new Random();
        int num = 10000_0000;
        int[] A = new int[num];
        for (int i = 0; i < num; i++) {
            A[i] = random.nextInt(1000000);
        }
        long start = System.currentTimeMillis();
        heapSort(A, A.length);
        long end = System.currentTimeMillis();
        System.out.println("duration:" + (end - start) + " ms");//duration:18589 ms
    }

    /**
     * 堆排序
     */
    public int[] heapSort(int[] A, int n) {
        //第一步：创建一个堆
        createHeap(A);
        int len = A.length;
        //从第一个非叶子节点开始（因为可以认为第一个非叶子节点下的左、右子树都是大顶堆）
        for (int i = n - 1; i > 0; i--) {
            //将堆顶（最大值）与最后一个元素交换
            swap(A, 0, i);
            //交换完之后，将最大值从逻辑上从堆中排除，此时左、右子树依然都是大顶堆。但是因为堆顶元素不一定是最大值，此时需要将二叉树重新调整成为堆。
            adjustToHeap(A, 0, --len);
        }
        return A;
    }

    //建立堆
    private void createHeap(int[] A) {
        if (A == null || A.length <= 1) {
            return;
        }
        /*
           对于一个完全二叉树，第一个非叶子节点的数组下标，需要记忆 ！！！
         */
        int lastNonLeafNodeIndex = A.length / 2 - 1;
        for (int i = lastNonLeafNodeIndex; i >= 0; i--) {
            adjustToHeap(A, i, A.length);
        }
    }

    /**
     * 对于一个堆A来说，index节点的左、右子节点都已经是大顶堆了，将以index为顶点的二叉树重新调整成为大顶堆。
     */
    private void adjustToHeap(int[] A, int index, int len) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        //不存在子节点（该节点是叶子节点）
        if (left >= len && right >= len) {
            return;
        }
        //仅存在左子节点
        if (right >= len) {
            if (A[index] < A[left]) {
                swap(A, index, left);
            }
            return;
        }
        //左、右子节点都存在
        if (A[left] > A[right]) {
            if (A[index] < A[left]) {
                swap(A, index, left);
                adjustToHeap(A, left, len);
            }
        } else if (A[left] < A[right]) {
            if (A[index] < A[right]) {
                swap(A, index, right);
                adjustToHeap(A, right, len);
            }
        } else {
            if (A[index] < A[left]) {
                swap(A, index, left);
                adjustToHeap(A, left, len);
            }
        }
    }

    private void swap(int[] A, int index1, int index2) {
        int temp = A[index1];
        A[index1] = A[index2];
        A[index2] = temp;
    }
}
