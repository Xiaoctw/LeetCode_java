package 数组;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("ALL")
public class 三数之和_15 {
    /**
     * 找到三个数,三个数的和为0
     * 给定数组当中可以存在重复数字,返回结果不能有重复数字
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int target = -nums[i];
            if (target < 0) {
                break;
            }
            int j = i + 1, k = len - 1;
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    lists.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    int v1 = nums[j], v2 = nums[k];
                    while (j < k && nums[j] == v1) {
                        j++;
                    }
                    while (j < k && nums[k] == v2) {
                        k--;
                    }
                } else if (nums[j] + nums[k] < target) {
                    j++;
                } else {
                    k--;
                }
            }
            while (i + 1 < len && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return lists;
    }

    @Test
    public void test() {
        int[] nums = {-1, 0, -1, 1, 2, -1, -4};
        List<List<Integer>> res = threeSum(nums);
    }
}
