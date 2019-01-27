package 树;


@SuppressWarnings("ALL")
public class 根据二叉树创建字符串_606 {

    public String tree2str(TreeNode t) {
        if (t == null) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(t.val);
        String left = tree2str(t.left);
        if (left != null) {
            builder.append("(");
            builder.append(left);
            builder.append(")");
        }
        String right = tree2str(t.right);
        if (right != null) {
            builder.append("(");
            builder.append(right);
            builder.append(")");
        }
        return builder.toString();
    }
}
