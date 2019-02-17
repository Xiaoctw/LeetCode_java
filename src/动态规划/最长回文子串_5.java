package 动态规划;

import org.junit.Test;

@SuppressWarnings("ALL")
public class 最长回文子串_5 {
    /**
     * 找到最长回文子串
     * "babad"
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len == 0) {
            return "";
        }
        boolean[][] dp = new boolean[len][len];
        int maxVal = 1;
        int beginIndex = 0;
        for (int l = 1; l <= len; l++) {
            for (int i = 0; i <= len - l; i++) {
                int j = i + l - 1;
                if (i == j) {
                    dp[i][j] = true;
                } else if (i == j - 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                }
                if (dp[i][j]) {
                    maxVal = Math.max(maxVal, j - i + 1);
                    beginIndex = i;
                }
            }
        }
        return s.substring(beginIndex, beginIndex + maxVal);
    }

    @Test
    public void test() {
        String s = "上海自来水来自海上a";
        System.out.println(longestPalindrome(s));
    }
}
