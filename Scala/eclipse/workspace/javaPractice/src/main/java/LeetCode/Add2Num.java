package LeetCode;

import LeetCode.DeleteDupList.ListNode;

public class Add2Num {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode fakeHead = new ListNode(0);

        int carry = 0;
        ListNode cur = fakeHead;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            cur.next = new ListNode(sum % 10);
            carry = sum / 10;
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.val + carry;
            cur.next = new ListNode(sum % 10);
            carry = sum / 10;
            cur = cur.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.val + carry;
            cur.next = new ListNode(sum % 10);
            carry = sum / 10;
            cur = cur.next;
            l2 = l2.next;
        }
        if (carry == 1)
            cur.next = new ListNode(1);
        return fakeHead.next;
    }
}
