package 树;


import org.junit.Test;

@SuppressWarnings("ALL")
public class 根据二叉树创建字符串_606 {

    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        builder.append(t.val);
        String left = tree2str(t.left);
        String right = tree2str(t.right);
        if (!left.equals("") && !right.equals("")) {
            builder.append("(");
            builder.append(left);
            builder.append(")");
            builder.append("(");
            builder.append(right);
            builder.append(")");
        } else if (left.equals("") && right.equals("")) {
        } else if (right.equals("")) {
            builder.append("(");
            builder.append(left);
            builder.append(")");
        } else {
            builder.append("()");
            builder.append("(");
            builder.append(right);
            builder.append(")");
        }
        return builder.toString();
    }

    @Test
    public void test() {

    }
}
