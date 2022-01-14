package string;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 给定一个字符串数组，再给定整数 k ，请返回出现次数前k名的字符串和对应的次数。
 * 返回的答案应该按字符串出现频率由高到低排序。如果不同的字符串有相同出现频率，按字典序排序。
 * 对于两个字符串，大小关系取决于两个字符串从左到右第一个不同字符的 ASCII 值的大小关系。
 * 比如"ah1x"小于"ahb"，"231"<”32“
 * 字符仅包含数字和字母
 *
 * 实现方式：
 * （1）比较器
 * （2）优先级队列
 * （3）堆
 */
public class TopK {

    @Test
    public void test() {
        String[] input = {"a", "b", "c", "b"};
        String[][] result = topKstrings(input, 2);
        for (String[] strings : result) {
            System.out.println(Arrays.toString(strings));
        }
    }

    @Test
    public void test2() {
        String[] input = {"abcd","abcd","abcd","pwb2","abcd","pwb2","p12"};
        String[][] result = topKstrings(input, 3);
        for (String[] strings : result) {
            System.out.println(Arrays.toString(strings));
        }
    }

    public String[][] topKstrings(String[] strings, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : strings) {
            map.merge(s, 1, Integer::sum);
        }
        List<Map.Entry<String, Integer>> list = map.entrySet().stream()
                .sorted((e1, e2) -> {
                    if (e1.getValue().equals(e2.getValue())) {
                        return e1.getKey().compareTo(e2.getKey());
                    } else {
                        return e2.getValue().compareTo(e1.getValue());
                    }
                }).collect(Collectors.toList());
        //int[m][n] 就是 m 行 n 列
        String[][] result = new String[k][2];
        for (int i = 0; i < k; i++) {
            Map.Entry<String, Integer> entry = list.get(i);
            result[i][0] = entry.getKey();
            result[i][1] = String.valueOf(entry.getValue());
        }
        return result;
    }
}
