package leetcode;

/**
 * Created by lijingxiao on 2018/11/29.
 *
 * 双指针
 *
 * 左右取较小的边作为高度，计算面积
 * 每次移动较小的一个边
 */
public class maxArea {
    public static int maxArea(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }

        int area=0,cur=0;
        int left = 0, right = height.length-1;
        while (left < right) {
            int min = Math.min(height[left], height[right]);
            cur = min*(right - left);
            area = Math.max(cur, area);
            if (height[left] < height[right]) {
                left ++;
            } else {
                right --;
            }
        }
        return area;
    }

    public static void main(String[] args) {
        int[] nums = {1,8,6,2,5,4,8,3,7};
        int area = maxArea(nums);
        System.out.println(area);
    }
}
