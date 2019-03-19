package 图;

public class 相似字符串组_839 {
    /**
     * 这个用C++完成!!!
     *
     * @param A
     * @return
     */
    public int numSimilarGroups(String[] A) {
        int numStr = A.length;
        return 0;
    }

    /**
     * 判断两个字符串是否相似
     *
     * @param s1
     * @param s2
     * @return
     */
    private boolean judge(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 != len2) {
            return false;
        }
        int index1 = 0, index2 = len2 - 1;
        for (int i = 0; i < len1; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                index1 = i;
                break;
            }
        }
        for (int j = len2 - 1; j > index1; j--) {
            if (s1.charAt(j) != s2.charAt(j)) {
                index2 = j;
                break;
            }
        }
        return s1.charAt(index1) == s2.charAt(index2) && s1.charAt(index2) == s2.charAt(index1);
    }
}
