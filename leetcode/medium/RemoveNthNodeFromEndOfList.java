/* 
19. Remove Nth Node From End of List

Given the head of a linked list, remove the nth node from the end of the list and return its head.

Note: Two pointers

*/


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
class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        ListNode slow = dummy;
        ListNode fast = dummy;
        int count = 0;
        dummy.next = head;
        while(fast.next != null) {
            if (count < n) {
                count++;
            } else {
                slow = slow.next;
            }
            fast = fast.next;
        }

        // remove the node at the end
        if (slow.next.next == null) {
            slow.next = null;
        } else {
            slow.next = slow.next.next;
        }
        
        return dummy.next;
    }
}