package sort.log2_n;

import org.junit.Assert;
import org.junit.Test;

/**
 * 有一个整形数组A，请设计一个复杂度为O(n)的算法，算出排序后相邻两数的最大差值。
 *
 * 给定一个int数组A和A的大小n，请返回最大的差值。保证数组元素多于1个。
 *
 * 测试样例：
 * [1,2,5,4,6],5
 * 返回：2
 *
 * 思路：桶排序。
 *
 * 只不过桶的大小比数组大1，而不是（max- min），这样桶的大小可控，不至于太大。
 * 另外，每个桶代表了一个数值的区间，因此一个桶内可以落入不同的数据（一个桶内的数据顺序是不确定的）
 * 但是本题目中只需要得到一个桶内的最大、最小值即可。
 */
public class Gap {

    @Test
    public void test() {
        int[] A = {2, 1, 3, 5, 1, 9, 8};
        int maxGap = maxGap(A, A.length);
        Assert.assertEquals(3, maxGap);
    }

    public int maxGap(int[] A, int n) {
        if (A == null || n <= 1) {
            return 0;
        }
        return max(A, A.length);
    }

    private int max(int[] A, int len) {
        //找最小、最大值
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int k : A) {
            min = Math.min(k, min);
            max = Math.max(k, max);
        }
        if (max == min) {
            return 0;
        }
        //注意：len + 1,而不是len，因为最大值的bucketIndex会是len
        boolean[] hasNum = new boolean[len + 1];
        int[] mins = new int[len + 1];
        int[] maxs = new int[len + 1];
        for (int j : A) {
            int bucketIndex = bucketNum(A, j, min, max);
            if (!hasNum[bucketIndex]) {
                mins[bucketIndex] = j;
                maxs[bucketIndex] = j;
            } else {
                mins[bucketIndex] = Math.min(mins[bucketIndex], j);
                maxs[bucketIndex] = Math.max(maxs[bucketIndex], j);
            }
            hasNum[bucketIndex] = true;
        }

        int lastHasNumIndex = -1;
        int maxGap = Integer.MIN_VALUE;
        for (int i = 0; i < hasNum.length; i++) {
            if (hasNum[i]) {
                if (lastHasNumIndex != -1) {
                    int gap = mins[i] - maxs[lastHasNumIndex];
                    maxGap = Math.max(maxGap, gap);
                }
                lastHasNumIndex = i;
            }
        }
        return maxGap;
    }

    private int bucketNum(int[] A, int value, int min, int max) {
        //注意：这里不要写成：(value - min) / (max - min) * A.length;
        //在数学上含义相同，但是实际上(value - min) / (max - min) 一直是 0
        return (value - min) * A.length / (max - min);
    }
}
