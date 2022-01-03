package string;

import org.junit.Assert;
import org.junit.Test;

/**
 * 对于一个字符串，请设计一个算法，将字符串的长度为len的前缀平移到字符串的最后。
 *
 * 给定一个字符串A和它的长度，同时给定len，请返回平移后的字符串。
 *
 * 测试样例：
 * "ABCDE",5,3
 * 返回："DEABC"
 */
public class Translation2 {

    @Test
    public void test() {
        Assert.assertEquals("DEABC", stringTranslation("ABCDE", 5, 3));
    }

    public String stringTranslation(String A, int len, int index) {
        char[] arr = A.toCharArray();
        swap(arr, 0, index - 1);
        swap(arr, index, len - 1);
        swap(arr, 0, len - 1);
        return new String(arr);
    }

    private void swap(char[] arr, int i, int j) {
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
