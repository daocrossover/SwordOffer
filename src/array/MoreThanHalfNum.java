package array;

/* 面试题39：数组中出现次数超过一半的数字
题目：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例
如输入一个长度为9的数组{1, 2, 3, 2, 2, 2, 5, 4, 2}。由于数字2在数组中
出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */

public class MoreThanHalfNum {
    // Boyer-Moore Voting Algorithm:
    // Time complexity: O(n), Space complexity: O(1)
    public int majorityElement(int[] nums) {
        // 当输入无效的时候进行处理
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 要找的数字肯定是最后一次将count设为0的数字
        int count = 1;
        int candidate = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (count == 0) {
                candidate = nums[i];
            }
            if (nums[i] == candidate) {
                count++;
            } else {
                count--;
            }
        }
        // 检验candidate出现的次数是否超过数组长度的一半
        count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }
        return count > nums.length / 2 ? candidate : 0;
    }
}
