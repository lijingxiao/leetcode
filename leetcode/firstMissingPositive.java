package leetcode;

import java.util.HashSet;

/**
 * Created by lijingxiao on 2018/11/27.
 *
 * 用一个HashSet记录当前正数，然后遍历 1~Integer.MAX_VALUE，没有的话就返回该值
 */
public class firstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length < 1)
            return 1;

        int ret = 0;
        HashSet<Integer> dataset = new HashSet<>();
        for (int i = 0;i < nums.length; i++) {
            if (nums[i] > 0) {
                dataset.add(nums[i]);
            }
        }
        for (int i = 1;i <= Integer.MAX_VALUE; i++) {
            if (!dataset.contains(i)){
                ret = i;
                break;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] num = {7,8,9,11,12};
        int ret = firstMissingPositive(num);
        System.out.println(ret);
    }
}
