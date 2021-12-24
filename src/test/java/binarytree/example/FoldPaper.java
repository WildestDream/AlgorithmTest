package binarytree.example;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 折纸问题：本质考察 中序遍历的递归。
 */
public class FoldPaper {

    @Test
    public void test() {
        String[] result = foldPaper(3);
        Assert.assertArrayEquals(new String[]{"down", "down", "up", "down", "down", "up", "up"}, result);
    }

    public String[] foldPaper(int n) {
        List<String> result = new ArrayList<>();
        print(false, 1, n, result);
        return result.toArray(String[]::new);
    }

    private void print(boolean left, int layer, int N, List<String> result) {
        if (layer >= N) {
            result.add(left ? "up" : "down");
            return;
        }
        print(false, layer + 1, N, result);
        result.add(left ? "up" : "down");
        print(true, layer + 1, N, result);
    }
}