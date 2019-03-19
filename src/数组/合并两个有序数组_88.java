package 数组;

import org.junit.Test;

@SuppressWarnings("ALL")
public class 合并两个有序数组_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n;
        int index = m + n - 1;
        int i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[index] = nums1[i];
                i--;
                index--;
            } else {
                nums1[index] = nums2[j];
                j--;
                index--;
            }
        }
        while (j >= 0) {
            nums1[index] = nums2[j];
            index--;
            j--;
        }
    }

    @Test
    public void test() {
        int[] nums1 = {1, 2, 3, 0, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
        System.out.println(nums1);
    }
}
