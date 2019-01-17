package leetcode;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by lijingxiao on 2018/12/13.
 * 输入: [3,2,3]
 输出: 3
 示例 2:

 输入: [2,2,1,1,1,2,2]
 输出: 2
 */
public class majority_element {
    public static int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int count = 0, ret = 0;
        for (int num : nums) {
            if (count == 0)
                ret = num;

            if (ret == num)
                count ++;
            else
                count--;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] num = {3,2,3};
//        int[] num = {2,2,1,1,1,2,2};
        int ret = majorityElement(num);
        System.out.println(ret);
    }
}
