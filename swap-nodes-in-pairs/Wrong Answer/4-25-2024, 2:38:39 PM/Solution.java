// https://leetcode.com/problems/swap-nodes-in-pairs

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode current = head;
        ListNode newHead = head.next;

        while (current != null && current.next != null) {
            // Swap current and next nodes even if next is null (handles end of list)
            ListNode next = current.next.next;
            current.next.next = current;

            if (prev != null) {
                prev.next = current.next;
            }

            // Advance pointers, even if next is null (prev points to the swapped node)
            prev = current;
            current = next;
        }

        return newHead;
    }
}
