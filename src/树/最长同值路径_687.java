package 树;

@SuppressWarnings("ALL")
public class 最长同值路径_687 {
    /**
     * 找到最长同值路径
     * @param root 根节点
     * @return 值
     */
    private int maxL=0;

    public int longestUnivaluePath(TreeNode root) {
        if (root==null){
            return 0;
        }
        getMaxL(root,root.val);
        return maxL;
    }
    private int getMaxL(TreeNode node,int val){
        if (node==null){
            return 0;
        }
        int left=getMaxL(node.left,node.val);
        int right=getMaxL(node.right,node.val);
        maxL=Math.max(maxL,left+right);
        if (node.val==val){
            return Math.max(left,right)+1;
        }
        return 0;
    }
}
