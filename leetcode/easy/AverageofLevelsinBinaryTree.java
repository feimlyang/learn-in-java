/*
637. Average of Levels in Binary Tree

Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. 
Answers within 10-5 of the actual answer will be accepted.
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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();
        preorder(root, res, 0, counts);
        for (int i = 0; i < counts.size(); i++) {
            res.set(i, res.get(i) / counts.get(i));
        }
        return res;
    }

    private void preorder(TreeNode node, List<Double> res, int level, List<Integer> counts) {
        if (node == null) return;

        if (res.size() - 1 < level) {
            counts.add(1);
            res.add((double)node.val);
        } else {
            counts.set(level, counts.get(level) + 1);
            res.set(level, res.get(level) + (double)node.val);
        }
        level++;
        preorder(node.left, res, level, counts);
        preorder(node.right, res, level, counts);
    }
}