package 数组;

import org.junit.Test;

import java.util.HashMap;

@SuppressWarnings("ALL")
public class 和可被K整除的子数组_974 {
    /**
     * 元素之和可以被K整除的子数组个数
     *
     * @param A
     * @param K
     * @return
     */
    public int subarraysDivByK(int[] A, int K) {
        int sum = 0;
        int count = 0;
        int len = A.length;
        int[] dp = new int[len];
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < len; i++) {
            sum = sum + A[i];
            dp[i] = sum % K;
            if (dp[i] < 0) {
                dp[i] = K + dp[i];
            }
            map.put(dp[i], map.getOrDefault(dp[i], 0) + 1);
        }
        for (int value : map.values()) {
            count = count + value * (value - 1) / 2;
        }
        return count;
    }

    @Test
    public void test() {
        int[] nums = {8, 9, 7, 8, 9};
        System.out.println(subarraysDivByK(nums, 8));
    }

}
