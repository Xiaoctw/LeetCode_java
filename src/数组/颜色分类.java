package 数组;

import org.junit.Test;

/**
 * 第75道题目
 */
@SuppressWarnings("ALL")
public class 颜色分类 {
    /**
     * 利用桶排序的思想
     * <p>
     * 输入: [2,0,2,1,1,0]
     * 输出: [0,0,1,1,2,2]
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int left = -1;
        int right = nums.length;
        int i = 0;
        while (i < right) {
            if (nums[i] == 0) {
                left++;
                exchange(nums, i, left);
                i++;//在这里需要递增是因为必须保证i大于left
            } else if (nums[i] == 2) {
                right--;
                exchange(nums, i, right);
            } else {
                i++;
            }
        }
    }

    private void exchange(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void test() {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        System.out.println();
    }
}
