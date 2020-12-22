/**
 * SumLists: You have two numbers represented by a linked list, where each node contains a single
digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a
function that adds the two numbers and returns the sum as a linked list.
 */
public class SumLists {
    private static class Node{
        Node next = null;
        int value;
        public Node(int value){
            this.value = value;
        }
    }
    public static int sumLists(Node head1, Node head2){
        if (head1 == null && head2 == null) return 0;
        int res = (head1 == null? 0 : head1.value) + (head2 == null? 0 : head2.value);
        int mag = 10;
        while (head1.next != null || head2.next != null){
            res += ((head1.next == null ? 0 : head1.next.value) + (head2.next == null ? 0 : head2.next.value)) * mag;
            mag *= 10;
            head1 = head1.next;
            head2 = head2.next;
        }
        return res;
    }


    public static void main(String[] args) {
        Node head1, head2, current1, current2;
        head1 = new Node (7);
        current1 = head1.next = new Node (1);
        current1 = current1.next = new Node (6);

        head2 = new Node (5);
        current2 = head2.next = new Node (9);
        current2 = current2.next = new Node (2);

        System.out.println(sumLists(head1, head2));
        
    }
}