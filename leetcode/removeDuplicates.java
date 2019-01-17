package leetcode;

/**
 * Created by lijingxiao on 2018/12/2.
 *
 * Rnum记录不重复的数字个数，i遍历数组，nums[i] 和 nums[Rnum]不相等的时候，Rnum++，并将不重复的数字放到该位置
 */
public class removeDuplicates {
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int Rnum=0, i=0;
        for (i = 0; i< nums.length; i++){
            if (nums[i] != nums[Rnum]) {
                nums[++Rnum] = nums[i];
            }
        }
        return ++Rnum; //因为从0开始的，最后要返回个数，所以还要加1
    }

    public static void main(String[] args) {
        int[] nums = {1};
//        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int ret = removeDuplicates(nums);
        System.out.println(ret);
        for (int i = 0; i < ret; i++) {
            System.out.print(nums[i]);
        }
    }
}
