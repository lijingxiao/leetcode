package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by lijingxiao on 2019/1/16.
 */
public class binary_tree_inorder_traversal {
    /**
     * 迭代后序
     * @param root
     * @return
     */
    public List<Integer> postOrder(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;
        TreeNode cur, pre = null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (! stack.isEmpty()) {
             cur = stack.peek();
            if ((cur.left == null && cur.right == null)
                    || (pre != null && (pre == cur.left || pre == cur.right))) {
                list.add(cur.val);
                stack.pop();
                pre = cur;
            } else {
                if (cur.left != null) stack.push(cur.left);
                if (cur.right != null) stack.push(cur.right);
            }
        }
        return list;
    }

    /**
     * 迭代先序
     * @param root
     * @return
     */
    public List<Integer> preOrder(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                list.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode pop = stack.pop();
            cur = pop.right;
        }
        return list;
    }

    /**
     * 迭代
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode pop = stack.pop();
            list.add(pop.val);
            cur = pop.right;
        }
        return list;
    }

    /**
     * 递归
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        dfs(root, list);
        return list;
    }
    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) return;
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        binary_tree_inorder_traversal bi = new binary_tree_inorder_traversal();
        List<Integer> integers = bi.inorderTraversal2(root);
//        List<Integer> integers = bi.inorderTraversal(root);
        System.out.println(Arrays.toString(integers.toArray()));

        List<Integer> pre = bi.preOrder(root);
        System.out.println(Arrays.toString(pre.toArray()));

        List<Integer> post = bi.postOrder(root);
        System.out.println(Arrays.toString(post.toArray()));
    }
}
