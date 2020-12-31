/**
 * Successor: Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a
binary search tree. You may assume that each node has a link to its parent.
 */
class Node{
    int value;
    Node parent;
    Node right;
    Node left;
    public Node(int value){
        this.value = value;
    }
    public Node(int value, Node parent, Node right, Node left){
        this.value = value;
        this.parent = parent;
        this.right = right;
        this.left = left;
    }
}
public class Successor {

    public static Node successor(Node n){
        if (n == null) return null;
        Node current;
        //if n has right node, "next" is the most left in the right substree.
        if (n.right != null){
            current = n.right;
            while(current.left != null){
                current = current.left;
            }
        }
        //if n has does not have right node, "next" is the closest untrasvered parent
        else{
            current = n;
            while (current.parent != null && current.parent.left != current){
                current = current.parent;
            }
            current = current.parent;
        }
        return current;
    }
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);
        a.right = b; 
        b.left = c;
        b.parent = a;
        c.left = d;
        c.right = e;
        c.parent = b; 
        d.parent = c;
        e.left = f;
        e.parent = c;
        f.parent = e;
        b.right = g;
        g.parent = b;

        //[a d c f e b g null]
        System.out.println(successor(a) == d);
        System.out.println(successor(d) == c);
        System.out.println(successor(c) == f);
        System.out.println(successor(f) == e);
        System.out.println(successor(e) == b);
        System.out.println(successor(b) == g);
        System.out.println(successor(g) == null);
        
    }
}