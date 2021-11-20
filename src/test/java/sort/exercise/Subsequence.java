package sort.exercise;


import org.junit.Assert;
import org.junit.Test;

/**
 * 对于一个数组，请设计一个高效算法计算需要排序的最短子数组的长度。
 *
 * 给定一个int数组A和数组的大小n，请返回一个二元组，代表所求序列的长度。(原序列位置从0开始标号,若原序列有序，返回0)。保证A中元素均为正整数。
 *
 * 测试样例：
 * [1,4,6,5,9,10],6
 * 返回：2
 *
 * 【注意】这个题目一直有一个误区：
 * 例如：1 3 2 4 5 6 7 10 9 8 11 这个数组中，（3,2） 以及 （10，9，8） 这两个序列都是需要调整的，但是返回的不是 2，而是 序列（3 2 4 5 6 7 10 9 8）的长度 9
 *
 * 题目更好地表达：对于一段数组A， 只要把其中的一段子序列排序了，整个数组就有序了，则这段子序列的最短长度是多少？
 */
public class Subsequence {

    @Test
    public void test() {
        int[] A = {1, 3, 2, 4, 5, 6, 7, 10, 9, 8, 11};
        int minSubLen = shortestSubsequence(A, A.length);
        Assert.assertEquals(9, minSubLen);
    }

    public int shortestSubsequence(int[] A, int n) {
        if (A == null || n <= 1) {
            return 0;
        }

        //找到最右侧的位置不对的那个数的位置
        int rightMostErrIndex = -1;
        int max = A[0];
        for (int i = 0; i < n; i++) {
            max = Math.max(max, A[i]);
            if (A[i] < max) {
                rightMostErrIndex = i;
            }
        }

        //找到最左侧的位置不对的那个数的位置
        int leftMostErrIndex = -1;
        int min = A[n - 1];
        for (int j = n - 1; j >= 0; j--) {
            min = Math.min(A[j], min);
            if (A[j] > min) {
                leftMostErrIndex = j;
            }
        }

        //两个位置不对的数的差值就是需要调整的最小子数组的长度。
        if (rightMostErrIndex == -1 && leftMostErrIndex == -1) {
            return 0;
        }
        return rightMostErrIndex - leftMostErrIndex + 1;
    }
}
