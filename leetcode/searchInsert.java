package leetcode;

/**
 * Created by lijingxiao on 2018/11/29.
 */
public class searchInsert {
    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length <= 0 || target <= nums[0]){
            return 0;
        }
        if (target > nums[nums.length-1]) {
            return nums.length;
        }

        int left = 0, right = nums.length-1;
        int ret = -1;
        while (left < right) {
            int mid = (left + right)/2;
            if (nums[mid] == target) {
                ret = mid;
                break;
            } else if (target > nums[left] && target < nums[mid]) {
                if (left == mid - 1) {
                    ret = mid;
                    break;
                }
                right = mid;
            } else {
                if (right == mid + 1) {
                    ret = mid + 1;
                    break;
                }
                left = mid;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {1,3};
        int target = 2;
        int ret = searchInsert(nums, target);
        System.out.println(ret);
    }
}

