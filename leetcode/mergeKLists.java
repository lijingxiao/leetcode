package leetcode;

/**
 * Created by lijingxiao on 2018/11/26.
 */
public class mergeKLists {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode dummyhead = new ListNode(0);
        ListNode cur = dummyhead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            cur = cur.next;
        }
        while (l1 != null) {
            cur.next = new ListNode(l1.val);
            l1 = l1.next;
            cur = cur.next;
        }
        while (l2 != null) {
            cur.next = new ListNode(l2.val);
            l2 = l2.next;
            cur = cur.next;
        }
        return dummyhead.next;
    }
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length < 1) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }

        int len = lists.length;
        while(len>1)//基于“二分”思想进行链表的两两组合
        {
            int mid=(len+1)/2;//二分
            for(int i=0;i<len/2;i++)
            {
                lists[i]=mergeTwoLists(lists[i],lists[i+mid]);
            }
            len=mid;
        }
        return lists[0];
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = {l1, l2, l3};
        ListNode ret = mergeKLists(lists);
        while (ret != null) {
            System.out.print(ret.val + " -> ");
            ret = ret.next;
        }
        System.out.println();
    }

}
