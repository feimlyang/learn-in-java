/**
 * FirstCommonAncestor: Design an algorithm and write code to find the first common ancestor
of two nodes in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not
necessarily a binary search tree.
 */

public class FirstCommonAncestor {
    private class Node{
        int value;
        Node parent;
        Node right;
        Node left;
        public Node(int value){
            this.value = value;
        }
    }
    //if has link to parent
    public static Node firstAncestor1(Node root, Node p, Node q){
        // Check if either node is not in the tree, or if one covers the other.
        if (!covers(root, p) || !covers(root, q)) return null;
        if (covers(p, q)) return p;
        if (covers(q, p)) return q;
        // p and q does not cover other. Traverse upwards from q until find a node that covers q.
        Node current = p;
        while(!covers(getSibling(current), q)){
            current = current.parent;
        }
        return current.parent;
    }
    //check if u is a ancestor v
    private static boolean covers(Node u, Node v){
        if (u == null) return false;
        if (u == v) return true;
        return covers(u.left, v) || covers(u.right, v);
    }
    private static Node getSibling(Node p){
        if (p == null || p.parent == null) return null;
        if (p.parent.left != p) return p.parent.left;
        if (p.parent.right != p) return p.parent.right;
        return null;
    }

    //Node without link to parent O(n)
    public static TreeNode firstAncestor2(TreeNode root, TreeNode p, TreeNode q){
        if (!covers2(root, p) || !covers2(root, q)) return null;
        return findAncestor(root, p, q);
    }
    private static boolean covers2(TreeNode u, TreeNode v){
        if (u == null) return false;
        if (u == v) return true;
        return covers2(u.left, v) || covers2(u.right, v);
    }
    private static TreeNode findAncestor(TreeNode root, TreeNode p, TreeNode q){
        if (root == null || root == p || root == q) return root;
        if ((!covers2(root.left, p) && covers2(root.left, q)) || (covers2(root.left, p) && !covers2(root.left, q))) return root;
        TreeNode next = covers2(root.left, p) && covers2(root.left, q) ? root.left: root.right;
        return findAncestor(next, p, q);
    }

    //discard covers() to avoid duplicated trace
    public static TreeNode firstAncestor3(TreeNode root, TreeNode p, TreeNode q){
        //TODO
        return root;
    }

    public static void test1(){
        FirstCommonAncestor fca = new FirstCommonAncestor();
        Node a = fca.new Node(1);
        Node b = fca.new Node(2);
        Node c = fca.new Node(3);
        Node d = fca.new Node(4);
        Node e = fca.new Node(5);
        Node f = fca.new Node(6);
        Node g = fca.new Node(7);
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

        System.out.println(firstAncestor1(a, d, g) == b); 
        System.out.println(firstAncestor1(a, e, g) == b); 
        System.out.println(firstAncestor1(a, a, b) == a); 
        System.out.println(firstAncestor1(a, d, f) == c);
        System.out.println(firstAncestor1(a, c, f) == c);
    }
    public static void test2(){
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        a.right = b; 
        b.left = c;
        c.left = d;
        c.right = e;
        e.left = f;
        b.right = g;

        System.out.println(firstAncestor2(a, d, g) == b); 
        System.out.println(firstAncestor2(a, e, g) == b); 
        System.out.println(firstAncestor2(a, a, b) == a); 
        System.out.println(firstAncestor2(a, d, f) == c);
        System.out.println(firstAncestor2(a, c, f) == c);
    }

    public static void main(String[] args) {
        test1();
        System.out.println();
        test2();
    }
}