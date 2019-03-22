package sorting;

/* 面试题51：数组中的逆序对
题目：在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组
成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数P。
并将P对1000000007取模的结果输出。 即输出P%1000000007
 */

public class InversePairsInArray {
    public int InversePairs(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; ++i) {
            copy[i] = array[i];
        }
        int count = mergeSort(array, copy, 0, array.length - 1);
        return count % 1000000007;
    }

    private int mergeSort(int[] array, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = array[start];
            return 0;
        }
        int sum = 0;
        int mid = start + (end - start) / 2;
        // 每次在sum增加时都取余
        // 将copy作为array传值
        sum = (sum + mergeSort(copy, array, start, mid)) % 1000000007;
        sum = (sum + mergeSort(copy, array, mid + 1, end)) % 1000000007;
        // left初始化为前半段第一个数字的下标，right初始化为后半段第一个数字的下标
        int left = start, right = mid + 1;
        int i = start;
        while (left <= mid && right <= end) {
            if (array[left] <= array[right]) {
                copy[i++] = array[left++];
            } else {
                copy[i++] = array[right++];
                sum = (sum + mid - left + 1) % 1000000007;
            }
        }
        while (left <= mid) {
            copy[i++] = array[left++];
        }
        while (right <= end) {
            copy[i++] = array[right++];
        }
        return sum % 1000000007;
    }
}
