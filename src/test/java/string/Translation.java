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
public class Translation {

    @Test
    public void test() {
        Assert.assertEquals("DEABC", stringTranslation("ABCDE", 5, 3));
    }

    public String stringTranslation(String A, int len, int index) {
        return A == null ? null : A.substring(index) + A.substring(0, index);
    }
}
