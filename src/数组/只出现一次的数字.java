package 数组;

public class 只出现一次的数字 {
    public int singleNumber(int[] nums) {
        int x = 0;
        for (int num : nums
        ) {
            x ^= num;
        }
        return x;
    }
}
