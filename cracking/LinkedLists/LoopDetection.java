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
        //TODO
        return head;
    }

    public static void main(String[] args) {
        
    }
    
}