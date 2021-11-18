package sort.n;

import org.junit.Test;

import java.util.Random;

/**
 * 计数排序的表现极为炸裂
 *
 * 1亿条数据的排序 0.5s 左右
 *
 * bucket的大小对 min, max 的差异比较敏感，数据越集中，越节省空间！
 */
public class CountingSort {

    @Test
    public void testPerf() {
        Random random = new Random();
        int num = 1_0000_0000;
        int[] A = new int[num];
        for (int i = 0; i < num; i++) {
            A[i] = random.nextInt(1000000);
        }
        long start = System.currentTimeMillis();
        countingSort(A, A.length);
        long end = System.currentTimeMillis();
        System.out.println("duration:" + (end - start) + " ms"); //445 ms
    }

    public int[] countingSort(int[] A, int n) {
        int max = A[0];
        int min = A[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(A[i], max);
            min = Math.min(A[i], min);
        }
        int bucketNum = max - min + 1;
        int[] buckets = new int[bucketNum];

        for (int i = 0; i < n; i++) {
            buckets[A[i] - min]++;
        }

        int index = 0;
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != 0) {
                for (int j = 0; j < buckets[i]; j++) {
                    A[index++] = i + min;
                }
            }
        }

        return A;
    }
}
