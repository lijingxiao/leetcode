package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by lijingxiao on 2018/12/10.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }

    public static ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        if (root == null) {
            return result;
        }

        queue.offer(root);
        result.add(root.val);
        System.out.println(root.val);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
//                System.out.println(head.val);

                if (head.left != null) {
                    queue.offer(head.left);
                    result.add(head.left.val);
                    System.out.print(head.left.val + " ");
                } else {
                    System.out.print(" null ");

                }
                if (head.right != null) {
                    queue.offer(head.right);
                    result.add(head.right.val);
                    System.out.print(head.right.val + " ");
                } else {
                    System.out.print(" null ");
                }
            }
            System.out.println();

        }
        return result;
    }
}
