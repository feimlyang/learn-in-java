/**
 * CheckBalanced
 */
public class CheckBalanced {
    public static boolean isBalanced(TreeNode root){
        return depth(root) != Integer.MIN_VALUE;

    }
    private static int depth(TreeNode node){
        if (node == null) return -1;
        int left = depth(node.left);
        if (left == Integer.MIN_VALUE) return Integer.MIN_VALUE;
        int right = depth(node.right);
        if (right == Integer.MIN_VALUE) return Integer.MIN_VALUE;
        if (Math.abs(left - right) > 1){
            return Integer.MIN_VALUE;
        }
        else{
            return Math.max(left, right) + 1;
        }
    }
    
}