/**
 * Intersection: Given two (singly) linked lists, determine if the two lists intersect. Return the
intersecting node. Note that the intersection is defined based on reference, not value. That is, if the
kth node of the first linked list is the exact same node (by reference) as the jth node of the second
linked list, then they are intersecting
 */
public class Intersection {
    private static class Node{
        Node next = null;
        int value;
        public Node(int value){
            this.value = value;
        }
    }
    //O(A+B) solution
    public static Node intersection(Node one, Node two){
        int len1 = 0, len2 = 0;
        Node current1 = one, current2 = two;
        while (current1 != null || current2 != null){
            if (current1 != null){
                len1++;
                current1 = current1.next;
            }
            if (current2 != null){
                len2++;
                current2 = current2.next;
            }
        }
        Node shorter= len1 - len2 < 0 ? one : two;
        Node longer = len1 - len2 >= 0 ? one : two;
        int lenDiff = Math.abs(len1-len2);
        while(lenDiff > 0) {
            longer = longer.next;
            lenDiff--;
        }
        while(shorter != null && longer != null){
            if (shorter.value == longer.value){
                return shorter;
            }
            shorter = shorter.next;
            longer = longer.next;
        }
        return shorter;
    }
    public static void main(String[] args) {
        Node head1 = new Node (1);
        Node head2 = new Node (4);
        Node intersect1 = new Node (7);
        Node intersect2 = new Node (7);
        head1.next = new Node(5);
        head1.next.next = new Node(9);
        head1.next.next.next = intersect1;
        head2.next = new Node(6);
        head2.next.next = intersect1;
        intersect1.next = intersect2;

        Node head3 = new Node(3);
        head3.next = new Node(4);

        System.out.println(intersection(head1, head2) == intersect1); 
        System.out.println(intersection(head1, head1) == head1);
        System.out.println(intersection(head1, head3) == null);

    }
    
}