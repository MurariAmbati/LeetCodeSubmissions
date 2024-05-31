// https://leetcode.com/problems/add-two-numbers-ii

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Reverse both input linked lists
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        
        // Initialize variables for addition and carry
        ListNode dummy = new ListNode(-1); // Dummy head for result list
        ListNode current = dummy;
        int carry = 0;
        
        // Traverse both linked lists and perform addition
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            // Update carry and create new node for result list
            carry = sum / 10;
            sum %= 10;
            current.next = new ListNode(sum);
            current = current.next;
        }
        
        // Reverse the result list and return
        return reverseList(dummy.next);
    }
    
    // Helper function to reverse a linked list
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }
        return prev;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = sol.addTwoNumbers(l1, l2);
        printList(result); // Output: [7,8,0,7]
        
        // Example 2
        l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        result = sol.addTwoNumbers(l1, l2);
        printList(result); // Output: [8,0,7]
        
        // Example 3
        l1 = new ListNode(0);
        l2 = new ListNode(0);

        result = sol.addTwoNumbers(l1, l2);
        printList(result); // Output: [0]
    }
    
    // Helper function to print the linked list
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}