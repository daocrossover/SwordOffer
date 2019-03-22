package tree;

/* 面试题8：二叉树的下一个结点
题目：给定一棵二叉树和其中的一个结点，如何找出中序遍历顺序的下一个结点？
树中的结点除了有两个分别指向左右子结点的指针以外，还有一个指向父结点的指针。
 */

/* 思路
1. 如果node有右子树，则下一个结点是它右子树中最左的结点
2. 如果node没有右子树，
    (1) 如果它是父结点的左子树，则下一个结点是父结点
    (2) 如果它是父结点的右子树，则沿着父结点指针向上遍历，直到找到一个是它父结点左结点的结点
 */

public class NextNodeInBinaryTree {
    class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;
        BinaryTreeNode parent;
    }

    BinaryTreeNode getNext(BinaryTreeNode node) {
        if (node == null) return null;
        BinaryTreeNode next = null;
        if (node.right != null) {
            BinaryTreeNode right = node.right;
            while (right.left != null) {
                right = right.left;
            }
            next = right;
        } else if (node.parent != null) {
            BinaryTreeNode cur = node;
            BinaryTreeNode curParent = node.parent;
            while (curParent != null && cur == curParent.right) {
                cur = curParent;
                curParent = curParent.parent;
            }
            next = curParent;
        }
        return next;
    }
}
