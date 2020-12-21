/**
 * KthToLast: Implement an algorithm to find the kth to last element of a singly linked list.
 */
public class KthToLast {
    private static class Node{
        Node next = null;
        int value;
        public Node(int value){
            this.value = value;
        }
    }

    public static Node kthToLast(Node head, int k){
        int len = 0;
        Node current = head;
        while (current != null){
            len++;
            current = current.next;
        }
        current = head;
        while (len-k > 0){
            if (current != null){
                current = current.next;
            }
            else{
                return null;
            }
            len--;
        }
        return current;
    }

    //better iterative solution
    public static Node kthToLastTwo(Node head, int k){
        Node p1 = head, p2 = head;
        while (k > 0){
            if (p1 != null) p1 = p1.next;
            else return null;
            k--;
        }
        while (p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    //recursive solution
    static int counter = 0;
    public static Node kthToLastThree(Node current, int k){
        if (current == null) return null;
        Node node = kthToLastThree(current.next, k);
        counter++;
        if (counter == k) return current;
        return node;
    }


    public static void main(String[] args) {
        Node current;
        Node head = new Node (1);
        current = head.next = new Node (2);
        current = current.next = new Node (4);
        current = current.next = new Node (3);
        current = current.next = new Node (9);
        System.out.println(kthToLastThree(head, 2).value);
        
        
    }
}