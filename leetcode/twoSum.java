package leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by lijingxiao on 2018/11/21.
 */
public class twoSum {
    /**
     * 两层循环，暴力解决
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        if (nums.length <= 1)
            return null;
        int[] ret = new int[2];
        for (int i=0;i< nums.length;i++) {
            for (int j=i+1; j< nums.length;j++) {
                if (nums[j] == target-nums[i]) {
                    ret[0] = i;
                    ret[1] = j;
                    break;
                }
            }
        }
        return ret;
    }

    /**
     * 利用 HashMap查找O(1)特性
     * 将数组中的元素作为key，对应的下标作为value，放入hashmap
     * 查找target-nums[i]
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        if (nums.length <= 1)
            return null;

        int ret[] = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            if (hashMap.containsKey(target - nums[i])) {
                ret[0] = i;
                ret[1] = hashMap.get(target-nums[i]);
                break;
            }
            hashMap.put(nums[i], i);
        }
        return ret;
    }

    public static void main(String[] args) {
        int input[] = {3,4};
        int[] ret = twoSum2(input, 7);
        System.out.println(Arrays.toString(ret));
    }
}
