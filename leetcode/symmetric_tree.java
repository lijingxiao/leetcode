package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by lijingxiao on 2018/12/17.
 *
 * 注意是 left.left 与 right.right比较
 * left.right 与 right.left比较
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 1
 / \
 2   2
 / \ / \
 3  4 4  3
 */
public class symmetric_tree {
    /**
     * 迭代
     * @param root
     * @return
     */
    public static boolean isSymmetric2(TreeNode root) {
        if (root == null)
            return true;

        Deque<TreeNode> tree = new LinkedList<>();
        tree.addFirst(root.left);
        tree.addLast(root.right);
        while (!tree.isEmpty()) {
            TreeNode first = tree.pollFirst();
            TreeNode last = tree.pollLast();

            if (first == null && last == null)
                continue;
            if (first == null || last == null)
                return false;
            if (first.val != last.val)
                return false;
            else {
                tree.addFirst(first.right);//先放right，再放left
                tree.addFirst(first.left);

                tree.addLast(last.left);
                tree.addLast(last.right);
            }
        }
        return true;
    }

    /**
     * 递归
     * @param left
     * @param right
     * @return
     */
    private static boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;

        if (left.val != right.val)
            return false;
        else
            return check(left.left, right.right) && check(left.right, right.left);

    }
    public static boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return check(root.left,root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
//        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
//        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        boolean ret = isSymmetric2(root);
//        boolean ret = isSymmetric(root);
        System.out.println(ret);

    }
}
