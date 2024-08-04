/*
112. Path Sum

Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

A leaf is a node with no children.
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSum(root, 0, targetSum);
    }

    private boolean hasPathSum(TreeNode node, int currentSum, int targetSum) {
        if (node == null) return false;
        if (node.left == null && node.right == null) {
            if (currentSum + node.val == targetSum) return true;
            else return false;
        }
        currentSum += node.val;
        return hasPathSum(node.left, currentSum, targetSum) || 
            hasPathSum(node.right, currentSum, targetSum);
    }
}