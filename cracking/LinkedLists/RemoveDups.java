import java.util.HashSet;


/**
 * RemoveDups: remove duplicates from an unsorted linked list.
 * How would you solve this problem if a temporary buffer is not allowed?
 */
public class RemoveDups {
    private static class Node{
        Node next = null;
        int value;
        public Node(int value){
            this.value = value;
        }
    }

    //O(n)
    public static void removeDups(Node n){
        HashSet<Integer> set = new HashSet<>();
        Node dummy = null;
        while (n != null){
            if (set.contains(n.value)){
                dummy.next = n.next;
            }
            else{
                set.add(n.value);
                dummy = n;
            }
            n = n.next;   
        }
    }

    //O(n^2) two pointers method
    public static void removeDupsNoBuffer(Node n){
        Node current = n;
        while (current != null){
            Node runner = current;
            while (runner.next != null){
                if (runner.next.value != current.value){
                    runner = runner.next;
                }
                else{
                    runner.next = runner.next.next;
                }
            }
            current = current.next;
        }
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
        
        removeDupsNoBuffer(head);
        LinkedListToString(head);
        
        
    }
}