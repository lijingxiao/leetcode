package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lijingxiao on 2019/1/14.
 */
public class populating_next_right_pointers_in_each_node {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        Queue<TreeLinkNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeLinkNode poll = q.poll();
            Queue<TreeLinkNode> q1 = new LinkedList<>();
            if (poll.left != null) q1.add(poll.left);
            if (poll.right != null) q1.add(poll.right);
            while (!q.isEmpty()) {
                TreeLinkNode poll1 = q.poll();
                poll.next = poll1;
                poll = poll1;
                if (poll.left != null) q1.add(poll.left);
                if (poll.right != null) q1.add(poll.right);
            }
            poll.next = null;
            while (!q1.isEmpty()) {
                q.add(q1.poll());
            }
        }
    }

    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        root.left.left = new TreeLinkNode(4);
        root.left.right = new TreeLinkNode(5);
        root.right.left = new TreeLinkNode(6);
        root.right.right = new TreeLinkNode(7);
        populating_next_right_pointers_in_each_node po = new populating_next_right_pointers_in_each_node();
        po.connect(root);
        TreeLinkNode.printFromTopToBottom(root);
    }
}
