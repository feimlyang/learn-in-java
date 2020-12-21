/**
 * DeleteMiddleNode: Implement an algorithm to delete a node in the middle (i.e., any node but
the first and last node, not necessarily the exact middle) of a singly linked list, given only access to
that node.
EXAMPLE
lnput:the node c from the linked list a->b->c->d->e->f
Result: nothing is returned, but the new linked list looks like a ->b->d->e->f
 */
public class DeleteMiddleNode {
    private static class Node{
        Node next = null;
        int value;
        public Node(int value){
            this.value = value;
        }
    }

    public static void deleteNode(Node node){
        node.value = node.next.value;
        node.next = node.next.next;
    }

    public static void LinkedListToString(Node n){
        System.out.print(n.value);
        Node current = n;
        while (current.next != null){
            System.out.print(" -> " + current.next.value);
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node current;
        Node head = new Node (1);
        current = head.next = new Node (3);
        current = current.next = new Node (4);
        current = current.next = new Node (3);
        current = current.next = new Node (9);
        current = current.next = new Node (9);
        deleteNode(head.next);
        LinkedListToString(head);
        
    }
}