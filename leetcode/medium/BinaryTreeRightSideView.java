/*
199. Binary Tree Right Side View

Given the root of a binary tree, imagine yourself standing on the right side of it, 
return the values of the nodes you can see ordered from top to bottom.
*/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res, 0);
        return res;
    }

    private void preorder(TreeNode node, List<Integer> res, int level) {
        if (node == null) return;
        // Each level incrasing will consume once either from left or right side
        if (res.size() == level) {
            res.add(level, node.val);
        }
        // Level increases for both left and right traverse
        level++;
        // Traverse right side first 
        // since iff the right side does not have node, we want left node
        preorder(node.right, res, level);
        preorder(node.left, res, level);

    }
}