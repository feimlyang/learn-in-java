/*
257. Binary Tree Paths

Given the root of a binary tree, return all root-to-leaf paths in any order.

A leaf is a node with no children.

Note:
为了构造string pattern "1->2->5", 需要提前一个level判断是否是最后一个val来update res.
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        path(root, res, "");
        return res;
    }

    private void path(TreeNode node, List<String> res, String path) {
        if (node == null) return;
        // Reach a leaf
        if (node.left == null && node.right == null) {
            path += String.valueOf(node.val);
            res.add(path);
        } else {
            path += String.valueOf(node.val) + "->";
            path(node.left, res, path);
            path(node.right, res, path);
        }
    }
}
