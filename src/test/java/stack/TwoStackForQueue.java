package stack;

import java.util.Stack;

/**
 * 编写一个类,只能用两个栈结构实现队列,支持队列的基本操作(push，pop)。
 *
 * 给定一个操作序列ope及它的长度n，其中元素为正数代表push操作，为0代表pop操作，保证操作序列合法且一定含pop操作，请返回pop的结果序列。
 *
 * 测试样例：
 * [1,2,3,0,4,0],6
 * 返回：[1,2]
 */
public class TwoStackForQueue {
    public int[] twoStack(int[] ope, int n) {
        TwoStackQueue queue = new TwoStackQueue();
        int[] res = new int[cal(ope)];
        int index = 0;
        for (int i : ope) {
            if (i > 0) {
                queue.offer(i);
            } else {
                int val = queue.pull();
                res[index++] = val;
            }
        }
        return res;
    }

    private int cal(int[] ope) {
        int num = 0;
        for (int i : ope) {
            if (i == 0) {
                num++;
            }
        }
        return num;
    }

    private static class TwoStackQueue {
        private final Stack<Integer> s1 = new Stack<>();
        private final Stack<Integer> s2 = new Stack<>();

        public void offer(int val) {
            s1.push(val);
        }

        public int pull() {
            if (!s2.isEmpty()) {
                return s2.pop();
            }
            if (s1.isEmpty()) {
                return -1;
            }
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            return s2.pop();
        }
    }

}
