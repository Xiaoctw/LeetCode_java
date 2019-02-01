package 蓄水池抽样;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@SuppressWarnings("ALL")
public class 随机数索引_398 {

    /**
     * 要求随机输出给定数字的索引
     *
     * @param nums 给定的数组
     */
    Map<Integer, List<Integer>> map = new HashMap<>();

    public 随机数索引_398(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                map.put(nums[i], new ArrayList<>());
                map.get(nums[i]).add(i);
            }
        }
    }

    public int pick(int target) {
        List<Integer> list = map.get(target);
        int size = list.size();
        int index = (int) (Math.random() * size);
        return list.get(index);
    }
}