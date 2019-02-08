package 数组;

import org.junit.Test;

@SuppressWarnings("ALL")
public class 删除排序数组中的重复项2_80 {
    /**
     * 每个元素最多保留两个
     *双指针法进行遍历
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[j]) {
                j++;
                nums[j] = nums[i];
                while (i + 1 < nums.length && nums[1 + i] == nums[j]) {
                    i++;
                }
            } else if (nums[i] > nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }

    @Test
    public void test() {
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int num = removeDuplicates(nums);
        for (int i = 0; i < num; i++) {
            System.out.println(nums[i]);
        }
    }
}
