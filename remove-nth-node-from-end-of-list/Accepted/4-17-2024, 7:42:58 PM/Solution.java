// https://leetcode.com/problems/remove-nth-node-from-end-of-list

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Pass 1: Count the number of nodes
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        // Pass 2: Remove the nth node from the end
        if (length == 0) return null; // Handle empty list
        int targetNode = length - n;
        current = head;
        ListNode prev = null;

        if (targetNode == 0) return head.next; // Remove head node

        for (int i = 0; i < targetNode; i++) {
            prev = current;
            current = current.next;
        }

        if (prev != null) {
            prev.next = current.next;
        }

        return head;
    }
}
