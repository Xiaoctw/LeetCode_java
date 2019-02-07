package 字符串;

@SuppressWarnings("ALL")
public class 不含AAA或BBB的字符串_984 {
    /**
     * 构建一个字符串,包含A个a和B个b,不能有aaa和bbb
     *
     * @param A
     * @param B
     * @return
     */
    public String strWithout3a3b(int A, int B) {
        StringBuilder sb = new StringBuilder();
        while (A > 0 || B > 0) {
            boolean writeA = false;
            int L = sb.length();
            if (L >= 2 && sb.charAt(L - 1) == sb.charAt(L - 2)) {
                if (sb.charAt(L - 1) == 'b') {
                    writeA = true;
                }
            } else {//当头两个字母不一样时,选择剩余多的
                if (A >= B) {
                    writeA = true;
                }
            }
            if (writeA) {
                A--;
                sb.append('a');
            } else {
                B--;
                sb.append('b');
            }
        }
        return sb.toString();
    }
}
