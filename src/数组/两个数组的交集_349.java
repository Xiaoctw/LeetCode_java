package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@SuppressWarnings("ALL")
public class 两个数组的交集_349 {
    /**
     * 找到两个数组的交集
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                set.remove(nums2[i]);
                list.add(nums2[i]);
            }
        }
        int[] A = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            A[i] = list.get(i);
        }
        return A;
    }
}
