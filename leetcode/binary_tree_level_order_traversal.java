package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by lijingxiao on 2019/1/16.
 */
public class binary_tree_level_order_traversal {
    /**
     * 迭代
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        dfs(root, list, 0);
        return list;
    }

    private void dfs(TreeNode root, List<List<Integer>> list, int level) {
        if (root == null) return;
        if (level > list.size()-1) {
            list.add(new ArrayList<>());
        }
        list.get(level).add(root.val);
        dfs(root.left, list, level + 1);
        dfs(root.right, list, level + 1);
    }


    /**
     * 迭代
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = q.poll();
                tmp.add(poll.val);
                if (poll.left != null) q.add(poll.left);
                if (poll.right != null) q.add(poll.right);
            }
            list.add(new ArrayList<>(tmp));
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        binary_tree_level_order_traversal bi = new binary_tree_level_order_traversal();
        List<List<Integer>> lists = bi.levelOrder2(root);
//        List<List<Integer>> lists = bi.levelOrder(root);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer +",");
            }
            System.out.println();
        }
    }
}
