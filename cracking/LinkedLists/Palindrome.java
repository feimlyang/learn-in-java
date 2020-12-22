/**
 * Palindrome: Implement a function to check if a linked list is a palindrome
 */
public class Palindrome {
    private static class Node{
        Node next = null;
        int value;
        public Node(int value){
            this.value = value;
        }
    }

    public static boolean isPalindrome(Node head){
        Node reversedHead = reverseLinkedList(head);
        while (head != null && reversedHead != null){
            if (head.value != reversedHead.value) return false;
            head = head.next;
            reversedHead = reversedHead.next;
        }
        return head == null && reversedHead == null;
    }

    //return a new copy 
    private static Node reverseLinkedList(Node head) {
        Node reversedHead = null;
        while (head != null){
            Node node = new Node (head.value);
            node.next = reversedHead;
            reversedHead = node;
            head = head.next;
        }
        return reversedHead;
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
        Node head = new Node (0);
        current = head.next = new Node (1);
        current = current.next = new Node (2);
        current = current.next = new Node (1);
        current = current.next = new Node (0);
        
        System.out.println(isPalindrome(head));
        
    }
}