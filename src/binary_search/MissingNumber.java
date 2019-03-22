package binary_search;

/* 面试题53（二）：0到n-1中缺失的数字
题目：一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字
都在范围0到n-1之内。在范围0到n-1的n个数字中有且只有一个数字不在该数组
中，请找出这个数字。
 */

public class MissingNumber {
    // 将问题转换为在有序数组中寻找第一个值与坐标不相等的元素
    public int GetMissingNumber(int[] array , int length) {
        if (array == null || length <= 0) return -1;
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] != mid) {
                if (mid == 0 || array[mid - 1] == mid - 1) {
                    return mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left == length) return length;
        // 无效的输入，比如数组不是按要求排序的，
        // 或者有数字不在0到n-1范围之内
        return -1;
    }
}
