package 树;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

@SuppressWarnings("ALL")
public class 二叉搜索树的最近公共祖先_235 {
    /**
     * 寻找到两个节点的最近公共祖先
     * 一个节点可以是它自己的祖先
     *这道题应该使用二叉搜索树的特性解决，不是遍历
     * @param root
     * @param p
     * @param q
     * @return
     */
    TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        find(root, p, q);
        return res;
    }

    private void find(TreeNode node, TreeNode p, TreeNode q) {
        if ((node.val - p.val) * (node.val - q.val) <= 0) {
            res = node;
        } else if (node.val < p.val && node.val < q.val) {
            find(node.right, p, q);
        } else {
            find(node.left, p, q);
        }
    }
}
