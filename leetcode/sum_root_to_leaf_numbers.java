package leetcode;

import java.util.ArrayList;

/**
 * Created by lijingxiao on 2018/12/20.
 *
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 计算从根到叶子节点生成的所有数字之和。
 示例 1:
 输入: [1,2,3]
   1
  / \
 2   3
 输出: 25
 解释:
 从根到叶子节点路径 1->2 代表数字 12.
 从根到叶子节点路径 1->3 代表数字 13.
 因此，数字总和 = 12 + 13 = 25.
 */
public class sum_root_to_leaf_numbers {
    public static int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        int ret = 0;
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        dfs(root,list, tmp);
        for (Integer integer : list) {
            ret += integer;
        }
        return ret;
    }

    private static void dfs(TreeNode root, ArrayList<Integer> list, ArrayList<Integer> tmp) {
        if (root == null)
            return;

        tmp.add(root.val);
        if (root.left == null && root.right == null) {
            int num = 0;
            for (Integer integer : tmp) {
                num = num*10 + integer;
            }
            list.add(num);
        }

        dfs(root.left, list, tmp);
        dfs(root.right, list, tmp);
        tmp.remove(tmp.size()-1);
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(3);
//        root.right = new TreeNode(2);

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);

        int ret = sumNumbers(root);
        System.out.println(ret);
    }
}
