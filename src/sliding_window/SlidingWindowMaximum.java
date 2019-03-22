package sliding_window;

/* 面试题59（一）：滑动窗口的最大值
题目：给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。例如，
如果输入数组{2, 3, 4, 2, 6, 2, 5, 1}及滑动窗口的大小3，那么一共存在6个
滑动窗口，它们的最大值分别为{4, 4, 6, 6, 6, 5}。
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class SlidingWindowMaximum {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (num == null || size <= 0) return res;
        // deque用来存储下标
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < num.length; ++i) {
            // 去掉deque中在滑动窗口之外的元素
            if (!q.isEmpty() && q.peek() < i - size + 1) {
                q.poll();
            }
            // 去掉deque队尾小于当前元素的元素
            while (!q.isEmpty() && num[q.peekLast()] < num[i]) {
                q.pollLast();
            }
            q.offer(i);
            // 滑动窗口的最大值总是位于deque的头部
            if (i >= size - 1) {
                res.add(num[q.peek()]);
            }
        }
        return res;
    }
}
