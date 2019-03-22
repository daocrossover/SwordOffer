package binary_search;

/* 面试题53（一）：数字在排序数组中出现的次数
题目：统计一个数字在排序数组中出现的次数。例如输入排序数组{1, 2, 3, 3,
3, 3, 4, 5}和数字3，由于3在这个数组中出现了4次，因此输出4。
 */

public class FindNumbersOfElementInSortedArray {
    public int GetNumberOfK(int[] array , int k) {
        if (array == null || array.length == 0) return 0;
        // 1. Find the first position of the element
        int low = 0, high = array.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // if target == array[mid], high = mid - 1
            // when low == high && target == array[mid], high = mid - 1,
            // then the loop is over, the low index is what should be found
            if (k <= array[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        // check if the low is over the range of the array and
        // if array[low] is equal to target
        if (low == array.length || array[low] != k) {
            return 0;
        }
        int left = low;
        // 2. Find the last position of the element
        low = 0;
        high = array.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // if target == array[mid], low = mid + 1
            // when low == high && target == array[mid], low = mid + 1,
            // then the loop is over, the high index is what should be found
            if (k >= array[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        int right = high;
        return right - left + 1;
    }
}
