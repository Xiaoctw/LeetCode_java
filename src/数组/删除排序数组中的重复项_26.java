package 数组;

import org.junit.Test;

@SuppressWarnings("ALL")
public class 删除排序数组中的重复项_26 {
    /**
     * 原地修改
     *
     * @param nums 数组
     * @return 新数组的长度
     */
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }

    @Test
    public void test() {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int num = removeDuplicates(nums);
        for (int i = 0; i < num; i++) {
            System.out.println(nums[i]);
        }
    }
}
