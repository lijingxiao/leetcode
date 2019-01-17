package leetcode;

/**
 * Created by lijingxiao on 2019/1/7.
 */
public class intersection_of_two_linked_lists {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        int l1 = 0, l2 = 0;
        ListNode c1 = headA, c2 = headB;
        while (c1 != null) {
            l1++;
            c1 = c1.next;
        }
        while (c2 != null) {
            l2++;
            c2 = c2.next;
        }
        c1 = headA;
        c2 = headB;
        if (l1 > l2) {
            for (int i = 0; i < l1 - l2; i++)
                c1 = c1.next;
        }
        if (l2 > l1) {
            for (int i = 0; i < l2 - l1; i++)
                c2 = c2.next;
        }

        while (c1 != null && c2 != null) {
            if (c1 == c2) return c1;
            c1 = c1.next;
            c2 = c2.next;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] n1 = {0,9,1,2,4};
        int[] n2 = {3,2,4};
        ListNode l1 = ListNode.buildFromArray(n1);
        ListNode l2 = ListNode.buildFromArray(n2);
        ListNode node = getIntersectionNode(l1, l2);
        ListNode.print(node);
    }
}
