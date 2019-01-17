package leetcode;

import java.util.Arrays;

/**
 * Created by lijingxiao on 2018/12/6.
 *
 * 输入:
 nums1 = [1,2,3,0,0,0], m = 3
 nums2 = [2,5,6],       n = 3

 输出: [1,2,2,3,5,6]
 */
public class merge_sorted_array {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2 == null || n ==0)
            return;

        int i = m-1, j = n-1, len = m + n -1;
        while ((i >= 0 || j >= 0) && len >= 0) {
            if (i >= 0 && j >= 0) {
                if (nums1[i] > nums2[j]) {
                    nums1[len] = nums1[i];
                    i--;
                } else {
                    nums1[len] = nums2[j];
                    j--;
                }
            } else if (j >= 0) {
                nums1[len] = nums2[j];
                j--;
            } else return;

            len--;
        }
    }

    public static void main(String[] args) {
//        int[] num1 = {0};
        int[] num1 = {4,5,6,0,0,0};
//        int[] num2 = {1};
        int[] num2 = {1,2,3};
        merge(num1, 3, num2, 3);
        System.out.println(Arrays.toString(num1));
    }

}
