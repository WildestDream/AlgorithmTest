package search;

import org.junit.Assert;
import org.junit.Test;

/**
 * 对于一个有序循环数组arr，返回arr中的最小值。有序循环数组是指，有序数组左边任意长度的部分放到右边去，右边的部分拿到左边来。比如数组[1,2,3,3,4]，是有序循环数组，[4,1,2,3,3]也是。
 *
 * 给定数组arr及它的大小n，请返回最小值。
 *
 * 测试样例：
 * [4,1,2,3,3],5
 * 返回：1
 */
public class OrderCycleArrMinVal {

    @Test
    public void test() {
        int[] arr = {4, 1, 2, 3, 3};
        int min = getMin(arr, arr.length);
        Assert.assertEquals(1, min);
    }

    @Test
    public void test2() {
        int[] arr = {3, 4, 1, 2, 3};
        int min = getMin(arr, arr.length);
        Assert.assertEquals(1, min);
    }

    @Test
    public void test3() {
        int[] arr = {3, 2};
        int min = getMin(arr, arr.length);
        Assert.assertEquals(2, min);
    }

    public int getMin(int[] arr, int n) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1) {
            return arr[0];
        }
        int left = 0;
        int right = n - 1;
        int mid = left + (right - left) / 2;
        while (left <= right) { //也可以写成true，因为一定存在最小
            if (arr[left] < arr[right]) {
                return arr[left];
            }
            if (arr[mid] > arr[left]) {
                left = mid + 1;
            } else if (arr[mid] < arr[right]) {
                right = mid;
            } else {
                break;
            }
            mid = left + (right - left) / 2;
        }
        return findMinimum(arr);
    }

    private int findMinimum(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
        }
        return min;
    }
}
