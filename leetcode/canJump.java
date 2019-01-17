package leetcode;

/**
 * Created by lijingxiao on 2018/11/30.
 *
 * 每一次最远距离为 i + nums[i]
 * reach记录全局最远距离
 */
public class canJump {
    public static boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return false;
        }
        int reach = nums[0];
        for (int i = 1; i< nums.length && reach >= i; i++ ) {
            if (i + nums[i] > reach) {
                reach = i + nums[i];
            }
        }
        return reach >= nums.length-1 ? true : false;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        boolean ret = canJump(nums);
        System.out.println(ret);
    }
}
