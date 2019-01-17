package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lijingxiao on 2018/12/3.
 */
public class combination_sum_ii {
    private static void find(int[] candidates, int target, ArrayList<Integer> tmp, List<List<Integer>> list, int index) {
        if (target == 0) {
            list.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = index; i < candidates.length && target >= candidates[i]; i++) {
            if (i > index && candidates[i] == candidates[i-1]) continue;
            tmp.add(candidates[i]);
            find(candidates, target - candidates[i], tmp, list, i+1);
            tmp.remove(tmp.size() - 1);
        }
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();

        Arrays.sort(candidates);
        find(candidates, target, tmp, list, 0);

        return list;
    }

    public static void main(String[] args) {
        int[] nums = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> lists = combinationSum2(nums, target);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + "  ");
            }
            System.out.println();
        }
    }


}
