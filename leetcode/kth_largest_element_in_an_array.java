package leetcode;


import java.util.PriorityQueue;

/**
 * Created by lijingxiao on 2018/12/28.
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 输出: 4
 */
public class kth_largest_element_in_an_array {
    private static int quickSortK(int[] nums, int k, int left, int right) {
        if (left == right) return nums[left];

        int i = left, j = right;
        int tmp = nums[left];
        while (i < j) {
            while (i < j && nums[j] >= tmp)
                j--;
            if (i < j)
                nums[i++] = nums[j];

            while (i < j && nums[i] <= tmp)
                i++;
            if (i < j)
                nums[j--] = nums[i];
        }
        nums[i] = tmp;

        if (i < k && i < right) return quickSortK(nums, k, i+1, right);
        if (i > k && i > left) return quickSortK(nums, k, left, i-1);
        return nums[k];
    }
    public static int findKthLargest(int[] nums, int k) {

        /**
         * 解法一
         * 排序，返回
         */
//        Arrays.sort(nums);
//        return nums[nums.length-k];

        /**
         * 解法二：
         * 快排，如果某个标杆正好在右边第k的位置，就返回
         */
//        return quickSortK(nums, nums.length-k, 0, nums.length - 1);

        /**
         * 小顶堆
         *
         * queue中维护k个数，那么这次输出的就是最后k个大的数
         */
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i< nums.length; i++) {
            queue.add(nums[i]);
            if (queue.size() > k)
                queue.poll();
        }
        return queue.poll();
    }

    public static void main(String[] args) {
        int[] num = {3,2,1,5,6,4};
        int k = 2;

//        int[] num = {3,2,3,1,2,4,5,5,6};
//        int k = 4;

        int kthLargest = findKthLargest(num, k);
        System.out.println(kthLargest);

    }
}
