package search;

/**
 * 有一个有序数组arr，其中不含有重复元素，请找到满足arr[i]==i条件的最左的位置。如果所有位置上的数都不满足条件，返回-1。
 *
 * 给定有序数组arr及它的大小n，请返回所求值。
 *
 * 测试样例：
 * [-1,0,2,3],4
 * 返回：2
 */
public class FindEqlIniPos {
    public int findPos(int[] arr, int n) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1) {
            return arr[0] == 0 ? 0 : -1;
        }
        int left = 0;
        int right = arr.length - 1;
        int mid = left + (right - left) / 2;
        int res = -1;
        while (left <= right) {
            if (arr[mid] > mid) {
                right = mid - 1;
            } else if (arr[mid] < mid) {
                left = mid + 1;
            } else {
                res = mid;
                right = mid - 1;
            }
            mid = left + (right - left) / 2;
        }
        return res;
    }
}
