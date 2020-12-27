import java.util.ArrayList;
import java.util.LinkedList;

/**
 * ListOfDepths: Given a binary tree, design an algorithm which creates a linked list of all the nodes
at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
 */

public class ListOfDepths {

    public static ArrayList<LinkedList<TreeNode>> listOfDepths(TreeNode root){
        ArrayList<LinkedList<TreeNode>> list = new ArrayList<>();
        listOfDepths(root, 0, list);
        return list;
    }
    private static void listOfDepths (TreeNode n, int depth, ArrayList<LinkedList<TreeNode>> list){
        if (n == null) return;
        if (list.size() == depth){
            LinkedList<TreeNode> nodesAtDepth = new LinkedList<>();
            list.add(nodesAtDepth);
        }
        list.get(depth).add(n);
        
        listOfDepths(n.left, depth + 1, list);
        listOfDepths(n.right, depth + 1, list);
    }

    public static void printTree(ArrayList<LinkedList<TreeNode>> tree){

        for (int i = 0; i < tree.size(); i++){
            System.out.print("depth " + i + ": ");
            for (TreeNode node : tree.get(i)){
                System.out.print(node.value + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] elems = {1,2,4,5,6,8,10,15,16,17,20,35}; 
        MinimalTree tree = new MinimalTree();
        TreeNode root = tree.createBST(elems);
        printTree(listOfDepths(root));
        
    }
}