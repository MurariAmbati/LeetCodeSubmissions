// https://leetcode.com/problems/remove-linked-list-elements

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // Handle empty list
        if (head == null) {
            return null;
        }

        // Handle removing the head node
        while (head != null && head.val == val) {
            head = head.next;
        }

        // Iterate through the list and remove matching nodes
        ListNode current = head;
        ListNode prev = null;
        while (current != null) {
            if (current.val == val) {
                // If removing the head, update head pointer
                if (prev == null) {
                    head = current.next;
                } else {
                    prev.next = current.next;
                }
            } else {
                prev = current;
            }
            current = current.next;
        }

        return head;
    }
}
