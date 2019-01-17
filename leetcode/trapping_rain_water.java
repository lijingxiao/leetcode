package leetcode;

/**
 * Created by lijingxiao on 2018/12/4.
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水
 */
public class trapping_rain_water {
    public static int trap(int[] height) {
        if (height == null || height.length == 0)
            return 0;

        int[] dp = new int[height.length];
        int max = 0;
        int ret = 0;
        for (int i = 0; i < height.length; i++) {
            dp[i] = max;//取当前位置左边的最高点
            max = Math.max(height[i], max);
        }

        max = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            dp[i] = Math.min(dp[i], max);//dp[i] 取左边最高点和右边最高点中较小的一个
            max = Math.max(height[i], max);
            if (dp[i] > height[i]) { // 如果dp[i]比当前元素大，证明有坑
                ret += dp[i] - height[i];
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        int ret = trap(nums);
        System.out.println(ret);
    }
}
