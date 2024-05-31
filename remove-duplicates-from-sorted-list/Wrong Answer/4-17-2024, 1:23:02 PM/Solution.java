// https://leetcode.com/problems/remove-duplicates-from-sorted-list

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) { // Handle empty or single-node list
            return head;
        }
        
        ListNode current = head;
        ListNode next = head.next;
        
        while (next != null) {
            if (current.val == next.val) {
                // Skip duplicate node
                next = next.next;
            } else {
                // No duplicate, move current forward
                current.next = next;
                current = current.next;
            }
            next = (next != null) ? next.next : null; // Update next pointer efficiently
        }
        
        return head;
    }
}
