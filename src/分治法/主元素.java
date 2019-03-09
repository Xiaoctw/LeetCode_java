package 分治法;

public class 主元素 {
    //删除两个不同的元素,整个序列的主元素保持不变
    public int majorityElement(int[] nums) {
        int res, cnt;
        res = nums[0];
        cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == res) {
                cnt++;
            } else if (cnt == 1) {
                res = nums[i];
                cnt = 1;
            } else {
                cnt--;
            }
        }
        return res;
    }
}
