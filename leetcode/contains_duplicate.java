package leetcode;

import java.util.HashSet;

/**
 * Created by lijingxiao on 2018/12/28.
 */
public class contains_duplicate {
    public static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 2)
            return false;

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i]))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] num = {1,1,1,3,3,4,3,2,4,2};
        boolean b = containsDuplicate(num);
        System.out.println(b);
    }
}
