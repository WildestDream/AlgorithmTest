package string;

import org.junit.Assert;
import org.junit.Test;

/**
 * 对于一个字符串，请设计一个算法，只在字符串的单词间做逆序调整，也就是说，字符串由一些由空格分隔的部分组成，你需要将这些部分逆序。
 *
 * 给定一个原字符串A和他的长度，请返回逆序后的字符串。
 *
 * 测试样例：
 * "dog loves pig",13
 * 返回："pig loves dog"
 */
public class Reverse {

    @Test
    public void test() {
        String input = "dog loves pig";
        Assert.assertEquals("pig loves dog", reverseSentence(input, input.length()));
    }

    public String reverseSentence(String A, int n) {
        if (A == null || n == 0 || n == 1) {
            return A;
        }
        String[] arr = A.split(" ");
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            swap(arr, left++, right--);
        }
        return buildResult(arr);
    }

    private void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private String buildResult(String[] arr) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < arr.length - 1; i++) {
            builder.append(arr[i]).append(" ");
        }
        builder.append(arr[arr.length - 1]);
        return builder.toString();
    }
}
