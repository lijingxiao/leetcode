package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lijingxiao on 2018/12/18.
 *
 * 快慢指针查找链表的中间值，同时将链表切分Wie两段
 * ***理解带返回值的递归
 *
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 给定的有序链表： [-10, -3, 0, 5, 9],

 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 */
public class convert_sorted_list_to_binary_search_tree {
    private static ListNode findMid(ListNode head) {
        if (head == null)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
                pre = slow;//指向前半段的结尾
                slow = slow.next;
            }
        }
        pre.next = null;//切割成两半
        return slow;
    }
    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        else if (head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode mid = findMid(head);
        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);

        return root;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);
        TreeNode root = sortedListToBST(head);
        TreeNode.printFromTopToBottom(root);
    }
}
