/* 
142. Linked List Cycle II

Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. 
Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). 
It is -1 if there is no cycle. Note that pos is not passed as a parameter.

Note: Floyd's Tortoise and Hare Algorithm
Define slow pointer and fast pointer. Fast pointer runs 2 times faster than slow pointer.
When slow pointer traverses the list once, the fast pointer must traverse the circle at least once if there is any.
The worst case is the fast pointer traverse twice of the whole list. There must be a collision.
Since 2 nodes can make a cycle, assume the fast pointer traverse into a minimal cycle and loop for k times. 
Since the fast pointer run 2 nodes in each step, it means there must be a collision.

Define a = length of the start to entrance of the cycle; b = length of the entrance to collision point; c = length of the cycle
we have 2(a + b) = a + b + kc to express the collision.

To find the entrance of the cycle, let fast pointer starts over from head and move both pointer at the same pace, then the collision is the entrance node.
For slow pointer, it will traverse a + c - (a + b) + k'c = c - b + k'c = (k' + 1)c - b = kc - b where k = k' is arbitrary integer;
We already know a + b = kc, then kc - b = a.
This means there exists a collision at the entrance of the cycle by such a movement. 

*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
        }
        
        return null;
    }
}