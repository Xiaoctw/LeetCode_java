package 数组;


import java.util.Arrays;

@SuppressWarnings("ALL")
public class 最长连续序列_128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int maxVal = 1, i = 0;
        while (i < nums.length - 1) {
            int j = i + 1;
            while (j < nums.length && (nums[j] == nums[j - 1] + 1 || nums[j] == nums[j - 1])) {
                j++;
            }
            maxVal = Math.max(maxVal, nums[j - 1] - nums[i] + 1);
            i = j;
        }
        return maxVal;
    }
}
