package leetcode;

/**
 * Created by lijingxiao on 2018/12/13.
 *
 * 思想：双指针，哪边小就移动哪边，移动之前记录较大的index值
 *
 * 输入: nums = [1,2,1,3,5,6,4]
 输出: 1 或 5
 解释: 你的函数可以返回索引 1，其峰值元素为 2；
 或者返回索引 5， 其峰值元素为 6。
 */
public class find_peak_element {
    public static int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        if (nums.length == 1)
            return 0;

        int left = 0, right = nums.length - 1;
        int index = 0;
        while (left <= right) {
            if (nums[left] < nums[right]) {
                index = right;
                left ++;
            } else {
                index = left;
                right --;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] num = {1,2,3,1};
//        int[] num = {1,2,1,3,5,6,4};
        int ret = findPeakElement(num);
        System.out.println(ret);
    }
}
