package leetcode;

/**
 * nums = [4,5,6,7,0,1,2], target = 0
 */
public class search_in_rotated_sorted_array {
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0 || (nums.length == 1 && nums[0] != target)) {
            return -1;
        }

        int ret = -1;
        int left = 0, rigth = nums.length-1;
        while (left <= rigth) {
            int mid = (left + rigth) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (target == nums[left])
                return left;
            if (target == nums[rigth])
                return rigth;

            if (nums[left] < nums[mid]) { //前半段严格升序，转折点在后半段
                if (target > nums[mid]) { //比mid大，肯定在后半段
                    left = mid + 1;
                } else {
                    if (target > nums[left]) { //比mid小，但是比left大，那么在前半段范围内
                        rigth = mid-1;
                    } else { //比mid小，也比left小，那么也在后半段
                        left = mid + 1;
                    }
                }
            } else { //后半段严格升序
                if (target < nums[mid]) { // 比mid小，肯定在前半段
                    rigth = mid -1;
                } else {
                    if (target < nums[rigth]) { //比mid大，但是比rigth小
                        left = mid + 1;
                    } else {
                        rigth = mid - 1;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] nums = {3,1};
        int[] nums = {4,5,6,7,0,1,2};
        int target = 3;
        int ret = search(nums, target);
        System.out.println(ret);
    }
}
