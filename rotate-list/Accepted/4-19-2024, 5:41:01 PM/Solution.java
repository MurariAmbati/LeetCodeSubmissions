// https://leetcode.com/problems/rotate-list

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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        
        // Step 1: Find the length of the linked list
        int length = 1;
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
            length++;
        }
        
        // Step 2: Calculate the effective rotation amount
        int effectiveRotation = k % length;
        if (effectiveRotation == 0) {
            return head;
        }
        
        // Step 3: Find the (length - k)th node from the beginning
        ListNode newTail = head;
        for (int i = 0; i < length - effectiveRotation - 1; i++) {
            newTail = newTail.next;
        }
        
        // Step 4: Adjust the pointers to rotate the list
        ListNode newHead = newTail.next;
        newTail.next = null; // Set the new tail's next pointer to null
        current.next = head; // Connect the original tail to the original head
        
        // Step 5: Return the new head of the rotated list
        return newHead;
    }

}