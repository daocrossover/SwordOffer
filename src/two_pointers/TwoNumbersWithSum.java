package two_pointers;

/* 面试题57（一）：和为s的两个数字
题目：输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们
的和正好是s。如果有多对数字的和等于s，输出任意一对即可。
 */

import java.util.ArrayList;

public class TwoNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int[] array,int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        int low = 0, high = array.length - 1;
        while (low < high) {
            int curSum = array[low] + array[high];
            if (curSum == sum) {
                res.add(array[low]);
                res.add(array[high]);
                return res;
            } else if (curSum > sum) {
                high--;
            } else {
                low++;
            }
        }
        return res;
    }
}
