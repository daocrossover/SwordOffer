package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LowestCommonAncestorOfTree {
    private static class CommonTreeNode {
        char val;
        ArrayList<CommonTreeNode> children;

        public CommonTreeNode(char val){
            this.val = val;
            children = new ArrayList<>();
        }

        public void addChildren(List<CommonTreeNode> children){
            this.children.addAll(children);
        }
    }

    // 方法1：需要辅助空间
    // 可以遍历两次(DFS)获取根节点到两个节点的路径，然后求两个路径的最后一个公共节点
    // 时间复杂度：O(n)，空间复杂度：O(logn)
    private static CommonTreeNode lowestCommonAncestor(CommonTreeNode root, CommonTreeNode p, CommonTreeNode q) {
        List<CommonTreeNode> path1 = new ArrayList<>();
        List<CommonTreeNode> path2 = new ArrayList<>();
        getPath(root, p, path1);
        getPath(root, q, path2);
        CommonTreeNode lastParent = null;
        for (int i = 0; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) == path2.get(i)) {
                lastParent = path1.get(i);
            } else {
                break;
            }
        }
        return lastParent;
    }

    private static boolean getPath(CommonTreeNode root, CommonTreeNode node, List<CommonTreeNode> curPath) {
        if (root == null) return false;
        ArrayList<CommonTreeNode> children = root.children;
        curPath.add(root);
        if (root == node) return true;
        if (children.size() > 0) {
            for (CommonTreeNode child : children){
                if (getPath(child, node, curPath)) {
                    return true;
                }
            }
        }
        curPath.remove(curPath.size() - 1);
        return false;
    }

    // 方法2：不需要辅助空间
    // 从根节点开始判断它的子树是否包含那两个结点，找到最小的的子树即可
    // 时间复杂度：O(n^2)（最差，需要重复遍历结点），空间复杂度：O(1)

    public static void main(String[] args){
        CommonTreeNode root = new CommonTreeNode('A');
        CommonTreeNode b = new CommonTreeNode('B');
        CommonTreeNode c = new CommonTreeNode('C');
        CommonTreeNode d = new CommonTreeNode('D');
        CommonTreeNode e = new CommonTreeNode('E');
        CommonTreeNode f = new CommonTreeNode('F');
        CommonTreeNode g = new CommonTreeNode('G');
        CommonTreeNode h = new CommonTreeNode('H');
        CommonTreeNode i = new CommonTreeNode('I');
        CommonTreeNode j = new CommonTreeNode('J');
        root.addChildren(Arrays.asList(b, c));
        b.addChildren(Arrays.asList(d, e));
        d.addChildren(Arrays.asList(f, g));
        e.addChildren(Arrays.asList(h, i, j));
        System.out.println(lowestCommonAncestor(root, f, h).val);
        System.out.println(lowestCommonAncestor(root, b, g).val);
    }
}
