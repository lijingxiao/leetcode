package leetcode;

/**
 * Created by lijingxiao on 2018/12/25.
 */
public class house_robber_ii {
    public static int robs(int start, int end, int[] nums) {
        int n = end - start + 1;
        int[] d = new int[n];
        d[0] = nums[start];
        if (n > 1)
            d[1] = Math.max(nums[start], nums[start + 1]);

        for (int i = 2; i < n; i++) {
            d[i] = Math.max(d[i-1], d[i-2] + nums[start + i]);
        }
        return d[n -1];
    }
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);

        return Math.max(robs(0, nums.length - 2, nums), robs(1, nums.length - 1, nums));
    }

    public static void main(String[] args) {
        int[] num = {1,2,1,1};
//        int[] num = {1,2,3,1};
        int rob = rob(num);
        System.out.println(rob);
    }
}
