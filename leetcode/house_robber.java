package leetcode;

/**
 * Created by lijingxiao on 2018/12/25.
 *
 * 极值问题，用动态规划，d[i] = max(d[i-1], d[i-2] + num[i])
 */
public class house_robber {
    public static int rob(int[] nums) {
        if (nums == null || nums.length== 0)
            return 0;

        int[] d = new int[nums.length];
        d[0] = nums[0];
        if (nums.length > 1)
            d[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            d[i] = Math.max(d[i-1], d[i-2] + nums[i]);
        }
        return d[nums.length -1];
    }

    public static void main(String[] args) {
        int[] num = {1,2};
//        int[] num = {2,7,9,3,1};
//        int[] num = {2,1,1,2};
        int rob = rob(num);
        System.out.println(rob);
    }
}
