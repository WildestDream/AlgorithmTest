package sort.exercise;

import org.junit.Test;

import java.util.Arrays;

/**
 *
 * 三色排序：
 *
 * 有一个只由0，1，2三种元素构成的整数数组，请使用交换、原地排序而不是使用计数进行排序。
 *
 * 给定一个只含0，1，2的整数数组A及它的大小，请返回排序后的数组。保证数组大小小于等于500。
 *
 * 测试样例：
 * [0,1,1,0,2,2],6
 * 返回：[0,0,1,1,2,2]
 */
public class ThreeColorSort {

    @Test
    public void test1() {
        int[] A = {0, 0, 0, 0, 0};
        sortThreeColor(A, A.length);
        System.out.println(Arrays.toString(A));
    }

    @Test
    public void test2() {
        int[] A = {1, 1, 1, 1, 1};
        sortThreeColor(A, A.length);
        System.out.println(Arrays.toString(A));
    }

    @Test
    public void test3() {
        int[] A = {2, 2, 2, 2, 2};
        sortThreeColor(A, A.length);
        System.out.println(Arrays.toString(A));
    }

    @Test
    public void test4() {
        int[] A = {2, 2, 0, 1, 0, 1};
        sortThreeColor(A, A.length);
        System.out.println(Arrays.toString(A));
    }

    public int[] sortThreeColor(int[] A, int n) {
        if (A == null || n <= 1) {
            return A;
        }
        int left = -1; //left以及以左：0
        int right = n; //right以及以右：1
        int index = 0; //index 以及以左：0,1序列
        while (index < right) {
            if (A[index] == 0) {
                swap(A, index++, ++left); //记得 index++
            } else if (A[index] == 2) {
                swap(A, index, --right);
            } else {
                index++;
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
