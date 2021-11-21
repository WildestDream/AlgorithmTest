package sort.N;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * 基数排序 O(N)
 *
 * 给定一个int数组A及数组的大小n，请返回排序后的数组。保证元素均小于等于2000。
 */
public class RadixSort {

    @Test
    public void test() {
        int[] A = {1, 1, 2, 3, 4, 2743, 6343, 2345, 424, 2, 2, 4, 24, 4, 23, 4, 324, 2};
        radixSort(A, A.length);
        System.out.println(Arrays.toString(A));
    }

    //39615ms
    @Test
    public void testPerf() {
        Random random = new Random();
        int num = 10000_0000;
        int[] A = new int[num];
        for (int i = 0; i < num; i++) {
            A[i] = random.nextInt(1000000);
        }
        long start = System.currentTimeMillis();
        radixSort(A, A.length);
        long end = System.currentTimeMillis();
        System.out.println("duration:" + (end - start) + " ms");//duration:18589 ms
    }

    public int[] radixSort(int[] A, int n) {
        if (A == null || A.length <= 1) {
            return A;
        }

        //建立10个桶，因为每个通过的元素的数量不确定，因此使用：list 表示你一个桶
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lists.add(new ArrayList<>());
        }

        //分别对个、十、百、千位排序，一共倒 4 次
        for (int i = 1; i <= 1000; i *= 10) {
            for (int j = 0; j < n; j++) {
                //计算每个数的桶的序号
                int bucketIndex = (A[j] / i) % 10;
                //将该数放到对应的桶中
                lists.get(bucketIndex).add(A[j]);
            }
            //将桶中的数据按照顺序倒出到A
            int index = 0;
            for (List<Integer> list : lists) {
                for (int v : list) {
                    A[index++] = v;
                }
                list.clear(); //记得clear
            }
        }
        return A;
    }
}
