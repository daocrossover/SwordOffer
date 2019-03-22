package backtracking;

/* 面试题38：字符串的排列
题目：输入一个字符串，打印出该字符串中字符的所有排列。例如输入字符串abc，
则打印出由字符a、b、c所能排列出来的所有字符串abc、acb、bac、bca、cab和cba。
 */

import java.util.Arrays;

public class StringPermutation {
    // 方法1：第一个数字起，每个数分别与它后面的数字交换，产生全排列
    void Permutation(String str) {
        if (str == null || str.length() == 0) return;
        backtrack(str, 0, str.length() - 1);
        // backtrack1(str, 0, str.length() - 1);
    }

    // 这样可能会产生重复的排列，如abb
    private void backtrack(String str, int start, int end) {
        if (start == end) {
            System.out.println(str);
        } else {
            for (int i = start; i <= end; ++i) {
                // 每次与第一个字母交换，产生新的前缀str = swap(str, start, i);
                str = swap(str, start, i);
                backtrack(str, start + 1, end);
                str = swap(str, start, i);
            }
        }
    }

    // 这样加入判断后可以避免产生重复的排列
    private void backtrack1(String str, int start, int end) {
        if (start == end) {
            System.out.println(str);
        } else {
            for (int i = start; i <= end; ++i) {
                if (isNeedSwap(str, start, i)) {
                    // 每次与第一个字母交换，产生新的前缀，然后固定
                    str = swap(str, start, i);
                    backtrack1(str, start + 1, end);
                    str = swap(str, start, i);
                }
            }
        }
    }

    private boolean isNeedSwap(String str, int start, int i) {
        boolean flag = true;
        for (int j = start; j < i; ++j) {
            if (str.charAt(j) == str.charAt(i)) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    private String swap(String str, int i, int j) {
        char[] arr = str.toCharArray();
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        return String.valueOf(arr);
    }

    // 方法2：不交换字符，直接进行回溯
    void Permutation1(String str) {
        if (str == null || str.length() == 0) return;
        char[] arr = str.toCharArray();
        // Arrays.sort(arr); // 处理重复情况
        boolean[] visited = new boolean[arr.length];
        backtrack(arr, visited, new StringBuilder());
        // backtrack1(arr, visited, new StringBuilder());
    }

    private void backtrack(char[] arr, boolean[] visited, StringBuilder tmp) {
        if (tmp.length() == arr.length) {
            System.out.println(tmp.toString());
        } else {
            for (int i = 0; i < arr.length; ++i) {
                if (visited[i]) continue;
                tmp.append(arr[i]);
                visited[i] = true;
                backtrack(arr, visited, tmp);
                tmp.setLength(tmp.length() - 1);
                visited[i] = false;
            }
        }
    }

    // 避免重复的排列，首先对数组进行排序，然后判断之前的
    private void backtrack1(char[] arr, boolean[] visited, StringBuilder tmp) {
        if (tmp.length() == arr.length) {
            System.out.println(tmp.toString());
        } else {
            for (int i = 0; i < arr.length; ++i) {
                if (visited[i]) continue;
                if (i > 0 && arr[i] == arr[i-1] && !visited[i-1]) continue;
                tmp.append(arr[i]);
                visited[i] = true;
                backtrack1(arr, visited, tmp);
                tmp.setLength(tmp.length() - 1);
                visited[i] = false;
            }
        }
    }
}
