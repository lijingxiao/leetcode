package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lijingxiao on 2018/11/23.
 */
public class threeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums.length < 3)
            return ret;
        Arrays.sort(nums);
        for (int i=0; i<nums.length && nums[i]<=0 ; i++) {
            //0,0,0,0  跳过重复项
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            int start=i+1, end=nums.length-1;
            while (start < end) {
                if (nums[start] + nums[end] == (0-nums[i])) {
                    ret.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    while (start < end && nums[start] == nums[start+1]){
                        start++;
                    }
                    while (start < end && nums[end] == nums[end-1]) {
                        end--;
                    }
                    start++;
                    end--;
                } else {
                    if (nums[start] + nums[end] > (0-nums[i])) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int nums[] = {0,0,0,0};
//        int nums[] = {-1, 0, 1, 2, -1, -4};
//        List<int[]> num = Arrays.asList(nums);
        List<List<Integer>> ret = threeSum(nums);
        for (int i=0;i<ret.size();i++) {
            System.out.println(Arrays.asList(ret.get(i)));
        }
    }
}
