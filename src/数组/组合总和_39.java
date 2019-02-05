package 数组;

import org.junit.Test;

import java.util.*;

@SuppressWarnings("ALL")
public class 组合总和_39 {
    /**
     * 找出所有可以使得数字和为target的组合
     *
     * @param candidates
     * @param target
     * @return
     */
    int pre = -1;
    long time1 = System.currentTimeMillis();
    long time2 = 0;
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
            time2 = System.currentTimeMillis();
            List<Integer> temp = new ArrayList<>(list);
            if (temp.get(0) != pre) {
                for (int i : temp
                ) {
                    System.out.printf("%d ", i);
                }
                System.out.println();
                System.out.println("当前数字执行时间" + (double) (time2 - time1));
                pre = temp.get(0);
                time1 = System.currentTimeMillis();
            }
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
        int[] candidates1 = {4, 6, 33, 4, 32, 13, 9, 16, 65, 32, 11, 4, 3, 12, 43, 42, 42, 4, 32, 25, 32, 65, 32};
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < candidates1.length; i++) {
            set.add(candidates1[i]);
        }
        int len = set.size();
        int[] A = new int[len];
        int i = 0;
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            A[i] = iterator.next();
            i++;
        }
        long time = System.currentTimeMillis();
        var res = combinationSum(A, 30);
        long time3 = System.currentTimeMillis();
        System.out.println("总时间" + (double) (time3 - time));
        return;
    }
}
