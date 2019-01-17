package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lijingxiao on 2018/12/20.
 */
public class binary_tree_paths {
    public static List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> list = new ArrayList<>();
        if (root == null)
            return list;
        ArrayList<Integer> tmp = new ArrayList<>();
        dfs(root, list, tmp);
        return list;
    }

    private static void dfs(TreeNode root, ArrayList<String> list, ArrayList<Integer> tmp) {
        if (root == null)
            return;
        tmp.add(root.val);
        if (root.left == null && root.right == null) {
            StringBuilder builder = new StringBuilder();
            for (Integer integer : tmp) {
                builder.append(integer + "->");
            }
            String s = builder.substring(0, builder.length() - 2).toString();
            list.add(s);
        }

        dfs(root.left, list, tmp);
        dfs(root.right, list, tmp);
        tmp.remove(tmp.size()-1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<String> list = binaryTreePaths(root);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
