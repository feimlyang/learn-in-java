/**
 * ValidateBST
 */
public class ValidateBST {
    //time O(n), space O(logn)
    public static boolean validateBST(TreeNode root){
        return validateBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }
    private static boolean validateBST(TreeNode n, int min, int max){
        if (n == null) return true;
        if (n.value <= min || n.value > max) return false;
        return validateBST(n.left, min, n.value) && validateBST(n.right, n.value, max);
    }

    public static void main(String[] args) {
        MinimalTree BST = new MinimalTree();
        ListOfDepths utils = new ListOfDepths();
        int[] elems = {2,4,5,7,8,9};
        TreeNode root = BST.createBST(elems);
        utils.printTree(utils.listOfDepths(root));
        System.out.println(validateBST(root));

    }
}