package leetcode;

/**
 * Created by lijingxiao on 2018/12/18.
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    public static ListNode buildFromArray(int[] num) {
        if (num == null || num.length < 1)
            return null;

        ListNode head = new ListNode(num[0]);
        ListNode cur = head;
        for (int i = 1; i< num.length; i++) {
            cur.next = new ListNode(num[i]);
            cur = cur.next;
        }
        return head;
    }

    public static void print(ListNode head) {
        if (head != null)
            System.out.print(head.val);
        head = head.next;
        while (head != null) {
            System.out.print(" -> " + head.val );
            head = head.next;
        }
        System.out.println();
    }
}
