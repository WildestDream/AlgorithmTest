package search;

import org.junit.Assert;
import org.junit.Test;

/**
 * 对于一个有序数组arr，再给定一个整数num，请在arr中找到num这个数出现的最左边的位置。
 *
 * 给定一个数组arr及它的大小n，同时给定num。请返回所求位置。若该元素在数组中未出现，请返回-1。
 *
 * 测试样例：
 * [1,2,3,3,4],5,3
 * 返回：2
 */
public class LeftMostAppearance2 {

    @Test
    public void test() {
        int[] arr = {1, 2, 3, 3, 4};
        int pos = findPos(arr, arr.length, 3);
        Assert.assertEquals(2, pos);
    }

    @Test
    public void test2() {
        int[] arr = {1, 2, 2, 2, 3, 3, 4};
        int pos = findPos(arr, arr.length, 3);
        Assert.assertEquals(4, pos);
    }

    public int findPos(int[] arr, int n, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1) {
            return arr[0] == num ? 0 : -1;
        }
        int res = -1;
        int left = 0;
        int right = n - 1;
        //注意，这里的num可能存在的范围是 [start, end] 的闭区间。
        int mid = left + (right - left) / 2;
        while (left <= right) {
            if (arr[mid] > num) {
                right = mid - 1;
            } else if (arr[mid] < num) {
                left = mid + 1;
            } else {
                res = mid;
                //从[start, mid-1]的范围再次寻找，看看还有没有更加左边的，已经找到的位置记到res里
                right = mid - 1;
            }
            mid = left + (right - left) / 2;
        }
        return res;
    }
}
