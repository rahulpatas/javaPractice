package LeetCode;

public class DeleteDupList {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public static ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (head!= null && head.next != null){

            if (head.val == head.next.val){

                while (head.next != null && head.val == head.next.val){
                    head = head.next;
                }

                prev.next = head.next;
                head = head.next;

            }else {

                head = head.next;
                prev = prev.next;

            }
        }

        return dummy.next;
    }

    public static class ListNode {
        int val;

        ListNode next;

        ListNode(int x)
        {
            val = x;
        }
    }

    public static void main(String[] args){

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);

        deleteDuplicates(head);
    }
}
