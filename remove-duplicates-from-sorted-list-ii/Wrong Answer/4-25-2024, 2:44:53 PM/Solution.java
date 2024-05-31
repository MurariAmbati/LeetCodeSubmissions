// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii

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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        boolean isDuplicate = false;
        
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                isDuplicate = true;
                curr = curr.next.next;
            } else if (isDuplicate) {
                prev.next = curr.next;
                curr = curr.next;
                isDuplicate = false;
            } else {
                prev = prev.next;
                curr = curr.next;
            }
        }
        
        if (isDuplicate) {
            prev.next = null;
        }
        
        return dummy.next;
    }
}