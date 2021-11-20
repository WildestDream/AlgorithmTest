package sort.exercise;

/**
 * 请设计一个高效算法，判断数组中是否有重复值。必须保证额外空间复杂度为O(1)。
 *
 * 给定一个int数组A及它的大小n，请返回它是否有重复值
 *
 * 思路：
 * （1）若没有空间复杂度的限制：使用hash表实现
 * （2）有空间复杂度的限制：则只能使用：冒泡、选择、插入，堆排序（非递归版本）
 *
 */
public class Checker {
    public boolean checkDuplicate(int[] a, int n) {
        //堆排序（非递归版本）最优解！但是较为复杂，略过
        return false;
    }
}
