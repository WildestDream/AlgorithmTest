package search;

import org.junit.Assert;
import org.junit.Test;

/**
 * 基础二分搜索，当元素重复时，选择最先出现的元素
 *
 * 跟元素最左出现相同
 */
public class BinarySearch {

    @Test
    public void test() {
        int[] arr = {1, 2, 3, 4, 5};
        Assert.assertEquals(0, biSearch(arr, 1));
        Assert.assertEquals(1, biSearch(arr, 2));
        Assert.assertEquals(2, biSearch(arr, 3));
        Assert.assertEquals(3, biSearch(arr, 4));
        Assert.assertEquals(4, biSearch(arr, 5));
        Assert.assertEquals(-1, biSearch(arr, 6));
    }

    @Test
    public void test2() {
        int[] arr = {1, 2, 2, 3, 3, 3, 3, 3, 4, 5, 5, 5};
        Assert.assertEquals(0, biSearch(arr, 1));
        Assert.assertEquals(1, biSearch(arr, 2));
        Assert.assertEquals(3, biSearch(arr, 3));
        Assert.assertEquals(8, biSearch(arr, 4));
        Assert.assertEquals(9, biSearch(arr, 5));
        Assert.assertEquals(-1, biSearch(arr, 100));
    }

    private int biSearch(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1) {
            return arr[0];
        }
        int res = -1;
        int left = 0;
        int right = arr.length - 1;
        int mid = left + (right - left) / 2;
        while (left <= right) {
            if (arr[mid] > num) {
                right = mid - 1;
            } else if (arr[mid] < num) {
                left = mid + 1;
            } else {
                res = mid;
                right = mid - 1; //当返回最后一个出现的元素的位置，left = mid + 1
            }
            mid = left + (right - left) / 2;
        }
        return res;
    }

}
