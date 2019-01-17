package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;

public class TreeLinkNode {
          int val;
          TreeLinkNode left, right, next;
          TreeLinkNode(int x) { val = x; }
    public static ArrayList<Integer> printFromTopToBottom(TreeLinkNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        LinkedList<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        if (root == null) {
            return result;
        }

        queue.offer(root);
        result.add(root.val);
        System.out.print(root.val);
        if (root.next == null)
            System.out.println(" -> null");
        else
            System.out.println(" -> ");
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeLinkNode head = queue.poll();
//                System.out.println(head.val);

                if (head.left != null) {
                    queue.offer(head.left);
                    result.add(head.left.val);
                    System.out.print(head.left.val + " ");
                    if (head.left.next == null)
                        System.out.print(" -> null");
                    else
                        System.out.print(" -> ");
                } else {
                    System.out.print(" null ");

                }
                if (head.right != null) {
                    queue.offer(head.right);
                    result.add(head.right.val);
                    System.out.print(head.right.val + " ");
                    if (head.right.next == null)
                        System.out.print(" -> null");
                    else
                        System.out.print(" -> ");
                } else {
                    System.out.print(" null ");
                }
            }
            System.out.println();

        }
        return result;
    }
}