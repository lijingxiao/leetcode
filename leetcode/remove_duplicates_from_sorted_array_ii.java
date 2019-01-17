package leetcode;

/**
 * Created by lijingxiao on 2018/12/7.
 */
public class remove_duplicates_from_sorted_array_ii {

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return 1;
        int Rnum = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[Rnum]) {
                nums[++Rnum] = nums[i];
            } else {
                nums[++Rnum] = nums[i];
                while (i < nums.length-1 && nums[i] == nums[i+1])
                    i++;
            }
        }
        return ++Rnum;
    }

    public static void main(String[] args) {
        int[] num = {1,1,1,2,2,3};
//        int[] num = {0,0,1,1,1,1,2,3,3};
        int index = removeDuplicates(num);
//        int index = removeDuplicates2(num);
        for (int i = 0; i < index; i++) {
            System.out.print(num[i]);
        }
    }
}
