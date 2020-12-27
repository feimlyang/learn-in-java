/**
 * MinimalTree: Given a sorted (increasing order) array with unique integer elements, write an
algorithm to create a binary search tree with minimal height
 */

public class MinimalTree {
    public static TreeNode createBST(int[] elems){
        return createBST(elems, 0, elems.length - 1);

    }
    private static TreeNode createBST(int[] elems, int start, int end){
        if (end < start) return null;
        int mid = (start + end) / 2;
        TreeNode n = new TreeNode(elems[mid]);
        n.left = createBST(elems, start, mid - 1);
        n.right = createBST(elems, mid + 1, end);
        return n;
    }

}