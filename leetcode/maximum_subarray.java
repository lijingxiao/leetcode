package leetcode;

/**
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 输出: 6
 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

 遍历数组，如果i之前的数据连续和 <= 0，就从i位置重新开始算起
 */
public class maximum_subarray {
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int maxSum = nums[0],cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (cur > 0) {
                cur = cur + nums[i];
            } else {
                cur = nums[i];
            }
            if (cur > maxSum)
                maxSum = cur;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {2,1};
        int ret = maxSubArray(nums);
        System.out.println(ret);
    }
}
