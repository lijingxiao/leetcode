package leetcode;

/**
 * Created by lijingxiao on 2018/11/21.
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class addTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;//指针
        int tmp=0, sum=0;
        while (l1 != null || l2 != null) {
//            sum = l1.val + l2.val + tmp;
            int v1 = l1 == null?0:l1.val;
            int v2 = l2 == null?0:l2.val;
            sum = v1 + v2 + tmp;
            tmp = sum/10;
            curr.next = new ListNode(sum%10);
            curr = curr.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        //最后一个进位
        if (tmp > 0) {
            curr.next = new ListNode(tmp);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode ret = addTwoNumbers(l1, l2);
        while (ret != null) {
            System.out.print(ret.val + "->");
            ret = ret.next;
        }
        System.out.println();
    }
}
