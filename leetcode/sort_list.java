package leetcode;

/**
 * Created by lijingxiao on 2018/12/27.
 *
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 输入: 4->2->1->3
 输出: 1->2->3->4
 */
public class sort_list {
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode slow = head, fast = head, pre = head;
        while (fast.next != null) {
            fast = fast.next;
            pre = slow;
            slow = slow.next;
            if (fast.next != null)
                fast = fast.next;
        }
        pre.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        return mergeList(left, right);
    }

    private static ListNode mergeList(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        if (left != null) {
            cur.next = left;
        }
        if (right != null) {
            cur.next = right;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(-1);

        ListNode listNode = sortList(head);
        while (listNode != null) {
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }
    }
}
