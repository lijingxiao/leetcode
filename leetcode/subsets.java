package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lijingxiao on 2018/12/6.
 */
public class subsets {
    private static void dfs(int[] nums, List<Integer> tmp, List<List<Integer>> list, int index) {
        if (index == nums.length) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            tmp.add(nums[i]);
            list.add(new ArrayList<>(tmp));
            dfs(nums, tmp, list, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<Integer> tmp = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();

        if (nums == null || nums.length == 0)
            return list;

        list.add(tmp);
        dfs(nums, tmp, list, 0);
        return list;
    }

    public static void main(String[] args) {
        int[] num = {1,2,3};
        List<List<Integer>> subsets = subsets(num);
        for (List<Integer> subset : subsets) {
            for (Integer integer : subset) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
