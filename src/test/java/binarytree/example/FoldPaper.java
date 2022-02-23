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

    private final List<String> result = new ArrayList<>();

    public String[] foldPaper(int n) {
        if (n <= 0) {
            return null;
        }
        traverse(false, n, 1);
        return copyListToArray(result);
    }

    private void traverse(boolean left, int n, int curLayer) {
        if (curLayer == n) {
            result.add(left ? "up" : "down");
            return;
        }
        traverse(false, n, curLayer + 1);
        result.add(left ? "up" : "down");
        traverse(true, n, curLayer + 1);
    }

    private String[] copyListToArray(List<String> result) {
        String[] arr = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }
}