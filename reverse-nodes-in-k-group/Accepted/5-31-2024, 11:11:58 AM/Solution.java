// https://leetcode.com/problems/reverse-nodes-in-k-group

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
    // Helper function to reverse a segment of the linked list
    private ListNode reverseLinkedList(ListNode head, int k) {
        ListNode newHead = null;
        ListNode ptr = head;
        
        while (k > 0) {
            ListNode nextNode = ptr.next;
            ptr.next = newHead;
            newHead = ptr;
            ptr = nextNode;
            k--;
        }
        
        return newHead;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode ptr = head;

        // Check if there are at least k nodes left in the linked list
        while (count < k && ptr != null) {
            ptr = ptr.next;
            count++;
        }

        // If we have k nodes, then we reverse them
        if (count == k) {
            // Reverse the first k nodes of the list and get the reversed list's head
            ListNode reversedHead = reverseLinkedList(head, k);
            
            // Recursively call the function to reverse the rest of the list
            head.next = reverseKGroup(ptr, k);
            
            // Return the new head of the reversed list
            return reversedHead;
        }

        // If we have less than k nodes, we just return the head as it is
        return head;
    }
}