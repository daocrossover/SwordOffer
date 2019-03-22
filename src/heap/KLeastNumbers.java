package heap;

/* 面试题40：最小的k个数
题目：输入n个整数，找出其中最小的k个数。例如输入4、5、1、6、2、7、3、8
这8个数字，则最小的4个数字是1、2、3、4。
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class KLeastNumbers {
    // 方法1：使用最大堆
    // 时间复杂度：O(nlogk)，适合处理海量数据
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        // k <= 0 和输入数组长度小于k的情况要考虑到
        if (input == null || input.length < k || input.length == 0 || k <= 0) {
            return res;
        }
        // 使用一个最大堆，当堆的大小小于k时往里面加元素，当大小为k时，如果当前元素比堆顶小才加入
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < input.length; ++i) {
            if (i < k) {
                pq.offer(input[i]);
            } else {
                if (input[i] < pq.peek()) {
                    pq.poll();
                    pq.offer(input[i]);
                }
            }
        }
        while (!pq.isEmpty()) {
            res.add(pq.poll());
        }
        return res;
    }

    // 方法2：借助快速排序的思路
    // 时间复杂度：O(n)，但是得修改输入数组的内容
    public ArrayList<Integer> GetLeastNumbers1(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (input == null || input.length < k || k <= 0) {
            return res;
        }
        int low = 0, high = input.length - 1;
        while (low <= high) {
            int index = partition(input, low, high);
            if (index == k - 1) {
                break;
            } else if (index < k - 1) {
                low = index + 1;
            } else {
                high = index - 1;
            }
        }
        for (int i = 0; i < k; ++i) {
            res.add(input[i]);
        }
        return res;
    }

    private int partition(int[] input, int low, int high) {
        int pivot = input[low];
        while (low < high) {
            while (low < high && input[high] >= pivot) --high;
            input[low] = input[high];
            while (low < high && input[low] <= pivot) ++low;
            input[high] = input[low];
        }
        input[low] = pivot;
        return low;
    }
}
