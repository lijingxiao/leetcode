package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 双指针，从0开始，当和小于s的时候移动右边界，大于s之后右移左边界，移动过程中更新长度值
 */
public class minimum_size_subarray_sum {
    public static int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0 || s <= 0)
            return 0;

        int left = 0, right = 0, cur = 0;
        int min = Integer.MAX_VALUE;
        while (left < nums.length && right < nums.length) {
            while (cur < s && right < nums.length) {
                cur += nums[right];
                right++;
            }
            while (cur >= s && left <= right) {
                min = Math.min(min, right - left);
                cur = cur - nums[left];
                left++;
            }
        }
        return min == Integer.MAX_VALUE?0:min;
    }

    public static void main(String[] args) {
        int[] num = {12,28,83,4,25,26,25,2,25,25,25,12};
        int s = 213;
        int res = minSubArrayLen(s, num);
        System.out.println(res);
    }
}
