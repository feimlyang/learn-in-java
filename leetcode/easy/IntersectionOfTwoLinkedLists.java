/* 
160. Intersection of Two Linked Lists

Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. 
If the two linked lists have no intersection at all, return null.

Note:
The length of two linked list might be different. 
If we get the length of them L1 and L2, then the intersection can be compared and found from [Max(L1, L2) - Min(L1, L2)]th node of the longer list and from the beginning of the shorter list.
This approach will need several traversals, still O(n).

Neat approach to find the starting node for comparison: 
Define pointer A and pointer B. Merge List B to A and A to B.
- Pointer A traverse at the end of List A, then point to the start of List B;
- Pointer B traverse at the end of List B, then point to the start of List A;
Assume List A is shorter:
Pointer A points at [Max(L1, L2) - Min(L1, L2)]th node of List B and pointer B starts at the beginning of List A. 
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
    }
}