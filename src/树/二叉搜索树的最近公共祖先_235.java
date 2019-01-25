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
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> nodes = new LinkedList<>();
        TreeNode res = null;
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            if (judge(node, p, q)) {
                res = node;
            }
            if (res == p || res == q) {
                return res;
            }
            if (node.left != null) {
                nodes.offer(node.left);
            }
            if (node.right != null) {
                nodes.offer(node.right);
            }
        }
        return null;
    }

    private boolean judge(TreeNode node, TreeNode p, TreeNode q) {
        boolean hasP = false;
        boolean hasQ = false;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode node1 = stack.pop();
            if (node1 == p) {
                hasP = true;
            } else if (node1 == q) {
                hasQ = true;
            }
            if (hasP && hasQ) {
                return true;
            }
            if (node1.left != null) {
                stack.push(node1.left);
            }
            if (node1.right != null) {
                stack.push(node1.right);
            }
        }
        return false;
    }
}
