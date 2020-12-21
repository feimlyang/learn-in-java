/**
 * Partition: Write code to partition a linked list around a value x, such that all nodes less than x come
before all nodes greater than or equal to x. If x is contained within the list the values of x only need
to be after the elements less than x (see below). The partition element x can appear anywhere in the
"right partition"; it does not need to appear between the left and right partitions.
EXAMPLE
Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition= 5]
Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 */
public class Partition {
    private static class Node{
        Node next = null;
        int value;
        public Node(int value){
            this.value = value;
        }
    }

    public static Node partition(Node head, int p){
        //find the node before the partition
        Node prevOfPartition = head;
        while (prevOfPartition.next != null && prevOfPartition.next.value != p){
            prevOfPartition = prevOfPartition.next;
        }
        //insert any node that value is greater than p after the partition to the next of the node before the partition.
        Node runner = prevOfPartition;
        while (runner.next != null ){
            if (runner.next.value < prevOfPartition.next.value){
                Node partition = prevOfPartition.next;
                Node selectedNode = runner.next;
                runner.next = runner.next.next;
                prevOfPartition.next = selectedNode;
                selectedNode.next = partition;
                prevOfPartition = prevOfPartition.next;
            }
            else{
                runner = runner.next;
            }
        }
        return head;
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
        Node head = new Node (3);
        current = head.next = new Node (5);
        current = current.next = new Node (2);
        current = current.next = new Node (5);
        current = current.next = new Node (10);
        current = current.next = new Node (1);
        current = current.next = new Node (9);
        LinkedListToString(partition(head, 5));
        
    }
}