package tree;

/* 面试题33：二叉搜索树的后序遍历序列
题目：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
如果是则返回true，否则返回false。假设输入的数组的任意两个数字都互不相同。
 */

public class PostOrderSequenceOfBST {
    public boolean verifySequenceOfBST(int[] sequence, int length) {
        return helper(sequence, 0, length);
    }

    private boolean helper(int[] sequence, int start, int length) {
        if (sequence == null || length <= 0) return false;
        int root = sequence[length - 1];
        // 在二叉搜索树中左子树的结点小于根结点
        int i = start;
        for (; i < length - 1; ++i) {
            if (sequence[i] > root) {
                break;
            }
        }
        // 在二叉搜索树中右子树的结点大于根结点
        int j = i;
        for (; j < length - 1; ++j) {
            if (sequence[j] < root) {
                return false;
            }
        }
        // 判断左子树是不是二叉搜索树
        boolean left = true;
        if (i > 0) left = helper(sequence, start, i);
        // 判断右子树是不是二叉搜索树
        boolean right = true;
        if (i < length - 1) right = helper(sequence, start + i, length - i - 1);
        return left && right;
    }
}
