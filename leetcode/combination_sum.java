package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lijingxiao on 2018/12/3.
 */
public class combination_sum {
    private static void find(int[] candidates, int target, List<Integer> num, List<List<Integer>> ret, int index) {
        if (target == 0) {
            ret.add(new ArrayList<>(num));
            return;
        }
        if (target < 0) {
            return;
        }

//        for (int i = index; i< candidates.length; i++) {
        for (int i = index; i< candidates.length && target >= candidates[i]; i++) {
            num.add(candidates[i]);
            find(candidates, target - candidates[i], num, ret, i);
            num.remove(num.size()-1);
        }

    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> num = new ArrayList<>();

        Arrays.sort(candidates);
        find(candidates, target, num, ret, 0);

        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {5,3,2};
        int target = 8;
        List<List<Integer>> lists = combinationSum(nums, target);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + ", ");
            }
            System.out.println();
        }
    }
}
