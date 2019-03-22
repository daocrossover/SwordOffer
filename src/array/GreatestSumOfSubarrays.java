package array;

/* 面试题42：连续子数组的最大和
题目：输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整
数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为O(n)。
输出连续子序列开始和结束的元素，并输出最大和
 */

public class GreatestSumOfSubarrays {
    void FindGreatestSumOfSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int start = 0, end = 0, tmp = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (sum <= 0) {
                sum = nums[i];
                // 重新记录开始的位置
                tmp = i;
            } else {
                sum += nums[i];
            }
            if (sum > max) {
                max = sum;
                start = tmp;
                end = i;
            }
        }
        System.out.println(nums[start] + " " + nums[end] + " " + max);
    }
}
