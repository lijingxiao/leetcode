package leetcode;

/**
 * Created by lijingxiao on 2018/12/12.
 *
 * 根据 mid 和 right 判断，如果mid < right，那么一点在前半段（包含mid），否则在后半段（不包含mid，因为mid至少比right大）
 */
public class find_minimum_in_rotated_sorted_array {
    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int left = 0, right = nums.length-1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[right]) { //最小点肯定在前半段（包含mid）
                right = mid;
            } else //不包含mid
                left = mid + 1;
        }
        return nums[right];
    }

    public static void main(String[] args) {
        int[] num = {4,5,6,7,0,1,2};
        int min = findMin(num);
        System.out.println(min);
    }
}
