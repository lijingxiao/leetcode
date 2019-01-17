package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lijingxiao on 2018/12/7.
 *
 * 一定要先排序，后面才能用和前一个元素对比表示是否跳过
 */
public class subsets_ii {

    private static void dfs(int[] nums, List<List<Integer>> list, List<Integer> tmp, int index) {
        if (index == nums.length){
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i-1])
                continue;
            tmp.add(nums[i]);
            list.add(new ArrayList<>(tmp));
            dfs(nums, list, tmp, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();

        if (nums == null || nums.length == 0)
            return list;
        list.add(new ArrayList<>(tmp));
        Arrays.sort(nums);
        dfs(nums, list, tmp, 0);
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {4,4,4,1,4};
        List<List<Integer>> lists = subsetsWithDup(nums);
        for (List<Integer> list : lists) {
            System.out.print("[");
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println("]");
        }
    }
}
