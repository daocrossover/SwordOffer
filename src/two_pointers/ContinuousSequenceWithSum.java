package two_pointers;

/* 面试题57（二）：为s的连续正数序列
题目：输入一个正数s，打印出所有和为s的连续正数序列（至少含有两个数）。
例如输入15，由于1+2+3+4+5=4+5+6=7+8=15，所以结果打印出3个连续序列1～5、
4～6和7～8。
 */

import java.util.ArrayList;

public class ContinuousSequenceWithSum {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (sum < 3) return res;
        int small = 1, big = 2;
        // 因为序列至少要两个数字，一直增加small到(1+sum)/2
        int mid = (1 + sum) / 2;
        int curSum = small + big;
        while (small < mid) {
            if (curSum == sum) {
                ArrayList<Integer> cur = new ArrayList<>();
                for (int i = small; i <= big; ++i) {
                    cur.add(i);
                }
                res.add(cur);
            }
            // 如果small到big的序列和大于s，从序列中去掉较小的值，增大small
            while (curSum > sum && small < mid) {
                curSum -= small;
                small++;
                if (curSum == sum) {
                    ArrayList<Integer> cur = new ArrayList<>();
                    for (int i = small; i <= big; ++i) {
                        cur.add(i);
                    }
                    res.add(cur);
                }
            }
            // 如果small到big的序列和小于s，让序列包含更多的数字，增大big
            big++;
            curSum += big;
        }
        return res;
    }
}
