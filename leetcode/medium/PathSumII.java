/*
113. Path Sum II

Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.

A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.

Note:
Binary tree traversal by path
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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        pathSum(root, res, path, targetSum, 0);
        return res;
    }

    private void pathSum(
        TreeNode node, 
        List<List<Integer>> res, 
        List<Integer> path, 
        int targetSum, 
        int currentSum) {
        if (node == null) return;

        path.add(node.val);
        currentSum += node.val;
        if (node.left == null && node.right == null) {
            if (currentSum == targetSum) {
                res.add(path);
            }
            return;
        }
        // Pass new copy of the path for each node traversal
        pathSum(node.left, res, new ArrayList<>(path), targetSum, currentSum);
        pathSum(node.right, res, new ArrayList<>(path), targetSum, currentSum);
    }
}