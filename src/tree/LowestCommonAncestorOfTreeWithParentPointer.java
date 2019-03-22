package tree;

import java.util.LinkedList;
import java.util.List;

/* 面试题68: 树中两个结点的最低公共祖先 (三)普通树中两个结点的最低公共祖先(有指向父结点的指针)
将问题转换为求两个链表的第一个公共结点
 */
public class LowestCommonAncestorOfTreeWithParentPointer {
    class CommonTreeNode {
        char val;
        List<CommonTreeNode> children;
        CommonTreeNode parent;

        public CommonTreeNode(char val){
            this.val = val;
            children = new LinkedList<>();
        }
    }

    public CommonTreeNode lowestCommonAncestor(CommonTreeNode root, CommonTreeNode p, CommonTreeNode q) {
        if (p == null || q == null) return null;
        CommonTreeNode a = p;
        CommonTreeNode b = q;
        while (a != b) {
            a = a == null ? q : a.parent;
            b = b == null ? p : b.parent;
        }
        return a;
    }
}
