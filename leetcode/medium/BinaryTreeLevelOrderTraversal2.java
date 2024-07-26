/*
107. Binary Tree Level Order Traversal II

Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).


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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        preorder(root, res, 0);
        return reverseArray(res);
    }

    private void preorder(TreeNode node, List<List<Integer>> res, int level) {
        if (node == null) return;
        if (res.size() - 1 < level) {
            List<Integer> arr = new ArrayList<>();
            res.add(arr);
        }
        res.get(level++).add(node.val);
        preorder(node.left, res, level);
        preorder(node.right, res, level);
    }

    private List<List<Integer>> reverseArray(List<List<Integer>> arr) {
        int left = 0;
        int right = arr.size() - 1;
        while (left < right) {
            List<Integer> temp = arr.get(left);
            arr.set(left++, arr.get(right));
            arr.set(right--, temp);
        }
        return arr;
    } 
}