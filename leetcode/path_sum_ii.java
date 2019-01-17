package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lijingxiao on 2018/12/19.
 *
 * 注意不能在root.val == sum 的时候return
 * 如果在这个时候return，那么需要把tmp中的最后一个元素去掉，才能进入右节点的dfs，否则左右节点会都出现子路径中
 * 而如果在这个时候就remove，而不在右子树dfs完成之后remove，会造成那些子不是叶子节点的节点不能正常退出（比如11）
 * 如果两个地方都remove，又会导致叶子节点多remove了一次，导致路径中少节点
 *
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 给定如下二叉树，以及目标和 sum = 22，
        5
      / \
     4   8
     /   / \
    11  13  4
 /  \    / \
 7    2  5   1
 */
public class path_sum_ii {
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null)
            return lists;
        List<Integer> tmp = new ArrayList<>();
        dfs(lists, tmp, root, sum);
        return lists;
    }

    private static void dfs(List<List<Integer>> lists, List<Integer> tmp, TreeNode root, int sum) {
        if (root == null)
            return;
        tmp.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                lists.add(new ArrayList<>(tmp));
            }
        }

        dfs(lists, tmp, root.left, sum - root.val);
        dfs(lists, tmp, root.right, sum - root.val);
        tmp.remove(tmp.size()-1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        List<List<Integer>> lists = pathSum(root, 22);
        for (List<Integer> list : lists) {
            System.out.print("[");
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println("]");
        }
    }
}
