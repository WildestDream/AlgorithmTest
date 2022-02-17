package sort.exercise;

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
 *  一般情况下，桶排序的桶的长度是 max- min，每个桶的下标来表示值，桶的值表示某个值出现的次数。
 *  但是本道题目的数据分布并不确定，max- min 可能很大。
 *
 *  因此，固定使用 len + 1 个桶，每个桶表示的大小是：（max - min）/ len，（最后一个元素独占一个桶）
 *  这样设计的目的： len 个元素放入 len + 1 个桶中，中间肯定会有空桶的出现，或者每个桶一个元素，
 *  这样，我们就可以保证：桶内元素的最大差值一定小于所有桶间相对的最大差值，因为至少空桶两边的桶的差值比任意一个桶内的元素的最大差值大，
 *  因此我们不可以不用关系桶内元素的最大差值，而只需要记录每个桶内元素的最大、最小值 max，min 即可。然后记录 前一个桶的 max 与 后一个桶的 min
 *  的差值 gap，依次遍历桶，找出 gap 最大的即可。
 *
 *
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

        //注意：len + 1,而不是len，这样才能“逼迫”出空桶
        boolean[] hasNum = new boolean[len + 1];
        int[] mins = new int[len + 1];
        int[] maxs = new int[len + 1];

        for (int val : A) {
            int bucketIndex = bucketNum(A, val, min, max);
            if (!hasNum[bucketIndex]) {
                mins[bucketIndex] = val;
                maxs[bucketIndex] = val;
            } else {
                mins[bucketIndex] = Math.min(mins[bucketIndex], val);
                maxs[bucketIndex] = Math.max(maxs[bucketIndex], val);
            }
            hasNum[bucketIndex] = true;
        }

        int lastHasNumIndex = -1; //上一个非空的桶的位置
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
