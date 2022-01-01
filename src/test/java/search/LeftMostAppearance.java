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
public class LeftMostAppearance {

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
        //先找到num出现的位置
        int index = findNumIndex(arr, n, num);
        //然后向左一直找，找到第一个num出现的位置。
        while (index >= 0) {
            if (arr[index] != num) {
                break;
            }
            index--;
        }
        return index + 1;
    }

    private int findNumIndex(int[] arr, int n, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1) {
            return arr[0] == num ? 0 : -1;
        }
        int left = 0;
        int right = n - 1;
        int mid = left + (right - left) / 2;
        //这一步是保持一个原则，即在搜索的过程中，left,right都不是num
        if (arr[right] == num) {
            return right;
        }
        while (left < right) {
            if (arr[mid] > num) {
                right = mid;
            } else if (arr[mid] < num) {
                left = mid;
            } else {
                return mid;
            }
            mid = left + (right - left) / 2;
        }
        return -1;
    }
}
