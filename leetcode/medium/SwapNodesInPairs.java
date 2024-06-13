/* 
24. Swap Nodes in Pairs

Given a linked list, swap every two adjacent nodes and return its head. 
You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

Note:
Use a dummy node to memorize the original head.
For each pair of swap if the pair exits:
temp -> left -> right 
temp -> right -> left
right -> left -> temp

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
class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        dummy.next = head;
        while (temp.next != null && temp.next.next != null) {
            ListNode left = temp.next;
            ListNode right = temp.next.next;
            left.next = right.next;
            temp.next = right;
            right.next = left;
            temp = left;
        }
        return dummy.next;
    }
}