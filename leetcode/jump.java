package leetcode;

/**
 * Created by lijingxiao on 2018/11/30.
 *
 * 每一步找到一个局部最优解：
 * 第一个节点必须要进入，每次进入一个起点i之后，下一步的落点可以是[i+1, i+nums[i]]，
 * 找到这个范围内的可以跳跃最远的点作为下一步。循环直到跳跃到最后。
 */
public class jump {
    public static int jump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int length = nums.length;
        int i = 0;
        int i_max = 0;
        int step = 0;
        while (i < length) {
            step ++;
            i_max = i + nums[i];
            if (i_max >= length-1) {
                break;
            }

            //找出当前位置应该跳到的下一个位置
            //也就是在[i+1, i+nums[i]]所有的点中，能够跳最远的一个位置
            int next = -1;
            int j_max = -1;
            for (int j = i + 1; j <= i_max; j++) {
                if (nums[j] + j > j_max) {
                    j_max = nums[j] + j;
                    next = j;
                }
            }
            i = next;
        }
        return step;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        int ret = jump(nums);
        System.out.println(ret);
    }
}
