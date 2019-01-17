package leetcode;

import com.sun.xml.internal.ws.addressing.WsaTubeHelperImpl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by lijingxiao on 2019/1/15.
 */
public class binary_tree_zigzag_level_order_traversal {
    private void reverse(ArrayList<Integer> list) {
        int i = 0, j = list.size() -1;
        while (i < j) {
            int tmp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, tmp);
            i++;
            j--;
        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        ArrayList<Integer> tmp = new ArrayList<>();
        int i = 0;
        while (!q.isEmpty()) {

            Queue<TreeNode> q1 = new LinkedList<>();
            while (!q.isEmpty()) {
                TreeNode poll = q.poll();
                tmp.add(poll.val);
                if (poll.left != null) q1.add(poll.left);
                if (poll.right != null) q1.add(poll.right);
            }
            if (i%2 == 1){
                reverse(tmp);
            }
            list.add(new ArrayList<>(tmp));
            tmp.clear();
            i++;
            while (!q1.isEmpty()) q.add(q1.poll());
        }
        return list;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.right.right = new TreeNode(5);
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        binary_tree_zigzag_level_order_traversal bi = new binary_tree_zigzag_level_order_traversal();
        List<List<Integer>> lists = bi.zigzagLevelOrder(root);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + ",");
            }
            System.out.println();
        }
    }
}
