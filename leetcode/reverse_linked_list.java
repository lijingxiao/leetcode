package leetcode;

/**
 * Created by lijingxiao on 2019/1/2.
 */
public class reverse_linked_list {
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head.next, next;
        head.next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] num = {1};
//        int[] num = {1,2,3,4,5};
        ListNode head = ListNode.buildFromArray(num);
        ListNode list = reverseList(head);
        ListNode.print(list);
    }
}
