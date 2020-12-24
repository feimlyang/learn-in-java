/**
 * LoopDetection: Given a circular linked list, implement an algorithm that returns the node at the
beginning of the loop.

let r1 be slow runner and r2 be the fast runner. r2 runs 2 times speed of r1.
Within the first round traverse of all nodes for r1, r1 and r2 collide at a node where the node is in the circle 
and r2 traversed the circle at least once. 
let ni be the node that r1 and r2 collide, nj be the start node of the circle, (the length from the head to nj) = (ni to nj).
r1: head to nj + nj to ni
r2: 2(head to nj + nj to ni) = head to nj + nj to ni + length of circle * k
so length of circle * k = head to nj + nj to ni
so head to nj = length of circle * k - nj to ni = ni to nj
 */
public class LoopDetection {
    private static class Node{
        Node next = null;
        int value;
        public Node(int value){
            this.value = value;
        }
    }

    public static Node detectLoop(Node head){
        Node slowRunner = head, fastRunner = head;
        do{
            if (fastRunner == null || fastRunner.next == null) return null;
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;
        }
        while (fastRunner != slowRunner);

        slowRunner = head;
        while (slowRunner != fastRunner){
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next;
        }
        return slowRunner;
    }

    public static void main(String[] args) {
        Node head = new Node(3);
        Node node1 = new Node(4);
        Node node2 = new Node(5);
        Node node3 = new Node(6);
        Node node4 = new Node(7);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node1;
        
        System.out.println(detectLoop(head) == node1);

    }
    
}