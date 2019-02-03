package 数组;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("ALL")
public class 组合总和_39 {
    /**
     * 找出所有可以使得数字和为target的组合
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> lists = new ArrayList<>();
        findList(lists, new ArrayList<>(), candidates, target, 0);
        return lists;
    }

    private void findList(List<List<Integer>> lists, List<Integer> list, int[] nums, int target, int index) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            List<Integer> temp = new ArrayList<>(list);
            lists.add(temp);
        }
        for (int i = index; i < nums.length && nums[i] <= target; i++) {
            List<Integer> temp = new ArrayList<>(list);
            temp.add(nums[i]);
            findList(lists, temp, nums, target - nums[i], i);
        }
    }

    @Test
    public void test() {
        int[] candidates = {2, 3, 6, 7};
        var res = combinationSum(candidates, 7);
        System.out.println();
        return;
    }
}
