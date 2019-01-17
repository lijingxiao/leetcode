package leetcode;

import java.util.HashSet;

/**
 * Created by lijingxiao on 2019/1/9.
 */
public class single_number {
    //两个相同的数异或为0，0异或任何数还是那个数
    public static int singleNumber2(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++)
            res ^= nums[i];
        return res;
    }
    public static int singleNumber(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i]))
                set.add(nums[i]);
            else
                set.remove(nums[i]);
        }
        return (Integer)set.toArray()[0];
    }

    public static void main(String[] args) {
        int[] num = {2,1,2};
        int n = singleNumber2(num);
        System.out.println(n);
    }
}
