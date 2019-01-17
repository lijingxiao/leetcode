package leetcode;

/**
 * Created by lijingxiao on 2018/12/24.
 */
public class maximum_product_subarray {
    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        /**
         * 方法一：动态规划，d[i][0]记录最大乘积，d[i][1]记录最小乘积
         */
//        int m = nums.length;
//        int[][] d = new int[m][2];
//        d[0][0] = nums[0];
//        d[0][1] = nums[0];
//        int ret = nums[0];
//        for (int i = 1; i < m; i++) {
//            d[i][0] = Math.max(Math.max(nums[i] * d[i-1][0], nums[i] * d[i-1][1]), nums[i]);
//            d[i][1] = Math.min(Math.min(nums[i] * d[i-1][0], nums[i] * d[i-1][1]), nums[i]);
//            ret = Math.max(d[i][0], ret);
//        }

        /**
         * 优化方法一的空间
         */
        int m = nums.length;
        int minp = nums[0], maxp = nums[0], ret = nums[0];
        for (int i = 1; i < m; i++) {
            int maxTmp = maxp * nums[i];
            int minTmp = minp * nums[i];
            maxp = Math.max(Math.max(maxTmp, minTmp), nums[i]);
            minp = Math.min(Math.min(maxTmp, minTmp), nums[i]);
            ret = Math.max(ret, maxp);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] num = {-4,-3,-2};
        int ret = maxProduct(num);
        System.out.println(ret);
    }
}
