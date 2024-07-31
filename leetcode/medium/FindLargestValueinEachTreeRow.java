/*
515. Find Largest Value in Each Tree Row

Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).
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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, 0, res);
        return res;
    }

    private void preorder(TreeNode node, int level, List<Integer> res) {
        if (node == null) return;
        if (res.size() - 1 < level) {
            res.add(node.val);
        } else {
            res.set(level, Math.max(res.get(level), node.val));
        }
        level++;
        preorder(node.left, level, res);
        preorder(node.right, level, res);
    }
}