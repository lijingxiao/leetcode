package leetcode;

import java.util.HashSet;

/**
 * Created by lijingxiao on 2018/12/11.
 *
 * 放入hashset中，遍历数组，取出已经存在的数，并向两边扩展
 *
 * 输入: [100, 4, 200, 1, 3, 2]
 输出: 4
 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
public class longest_consecutive_sequence {
    public static int longestConsecutive(int[] nums) {
        if (nums == null)
            return 0;
        if (nums.length <= 1)
            return nums.length;

        HashSet<Integer> sets = new HashSet<>();
        for (int i = 0; i< nums.length; i++) {
            sets.add(nums[i]);
        }
        int max = 0;
        for (int num : nums) {
            sets.remove(num);
            int left = num - 1, right = num + 1;
            while (sets.remove(left)) left--;
            while (sets.remove(right)) right ++;
            max = Math.max(max, right - left -1);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] num = {100, 4, 200, 1, 3, 2};
        int ret = longestConsecutive(num);
        System.out.println(ret);
    }
}
