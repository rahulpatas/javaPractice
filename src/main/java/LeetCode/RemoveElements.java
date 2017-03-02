package LeetCode;

public class RemoveElements {
    public DeleteDupList.ListNode removeElements(DeleteDupList.ListNode head, int val) {

        if (head == null) {
            return null;
        }

        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}
