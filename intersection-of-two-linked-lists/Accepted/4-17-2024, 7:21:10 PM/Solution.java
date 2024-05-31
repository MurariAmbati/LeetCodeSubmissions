// https://leetcode.com/problems/intersection-of-two-linked-lists

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA = headA, currB = headB;
        while (currA != currB) {
            currA = currA == null ? headB : currA.next;
            currB = currB == null ? headA : currB.next;
        }
        return currA;
    }
}
