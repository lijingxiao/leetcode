package leetcode;

/**
 * Created by lijingxiao on 2019/1/9.
 */
public class linked_list_cycle {
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = head;
        boolean b = hasCycle(head);
        System.out.println(b);
    }
}
