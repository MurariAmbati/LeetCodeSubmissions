// https://leetcode.com/problems/reverse-linked-list-ii

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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Move prev to the node just before the sublist to be reversed
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        // Start is the node from which we start reversing
        ListNode start = prev.next;
        // Tail is the node at the end of the sublist to be reversed
        ListNode tail = start;
        // Move tail to the node at position 'right'
        for (int i = left; i < right; i++) {
            tail = tail.next;
        }

        // Remove the sublist from the original list
        prev.next = null;
        // Store the next node after the sublist
        ListNode next = tail.next;
        // Reverse the sublist
        tail.next = null;
        reverse(start);

        // Connect the reversed sublist back to the original list
        prev.next = tail;
        start.next = next;

        return dummy.next;
    }
}