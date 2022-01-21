package string;

import org.junit.Assert;
import org.junit.Test;

/**
 * 大数运算
 */
public class BigStringAdd {
    @Test
    public void test() {
        String result = add("1", "2");
        Assert.assertEquals("3", result);
    }

    @Test
    public void test2() {
        String result = add("199", "1");
        Assert.assertEquals("200", result);
    }

    @Test
    public void test3() {
        String result = add("981", "19");
        Assert.assertEquals("1000", result);
    }

    @Test
    public void test4() {
        String result = add("1234123412341234123412341234123412341234", "1234123412341234123412341234123412341234");
        Assert.assertEquals("2468246824682468246824682468246824682468", result);
    }

    private String add(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int i = chars1.length - 1;
        int j = chars2.length - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? chars1[i] - '0' : 0;
            int n2 = j >= 0 ? chars2[j] - '0' : 0;
            int sum = n1 + n2 + carry;
            carry = sum / 10;
            builder.insert(0, sum % 10);
            i--;
            j--;
        }
        if (carry != 0) {
            builder.insert(0, 1);
        }
        return builder.toString();
    }


    @Test
    public void test10() {
        long l = System.currentTimeMillis();
        System.out.println(l);
    }
}
