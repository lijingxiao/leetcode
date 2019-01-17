package leetcode;

import java.util.Arrays;

/**
 * Created by lijingxiao on 2018/11/27.
 *
 * 申请两枚指针，head 和 tail，用 i 进行遍历，head最终指向第一个1的位置，tail指向第一个非2的位置
 * 当 num[i] == 0时，交换当前位置和头指针处值，
 * 当 nums[i] == 2时，交换当前位置和尾指针处值，
 * 当 nums[i] == 1时，不进行交换
 */
public class sortColors {
    public static void sortColors(int[] nums) {
        if (nums == null || nums.length<2) {
            return;
        }

        int left = 0, right = nums.length-1, i = 0;
        while (i <= right) {
            if (nums[i] == 0) {
                swap(nums, i, left);
                i++;
                left++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, i ,right);
                right--;
            }
        }
    }

    public static void swap(int[] num, int a, int b) {
        int tmp = num[a];
        num[a] = num[b];
        num[b] = tmp;
    }
    public static void main(String[] args) {
        int[] nums = {2,0,1};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
