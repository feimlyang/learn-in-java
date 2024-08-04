/*
513. Find Bottom Left Tree Value

Given the root of a binary tree, return the leftmost value in the last row of the tree.

Note:
花了点时间在debug只有一个node的情况, 忘记初始maxLevel为Integer.MIN_VALUE. Leftmost node实际上就是每次level增加的时候第一个遍历到的node因为我们先traverse了left node, 如果在新的level child node只有right node即这个node为leftmost node.

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
    private int maxLevel = Integer.MIN_VALUE;
    private int res = 0;
    public int findBottomLeftValue(TreeNode root) {
        findBottomLeftValue(root, 0);
        return res;
    }

    private void findBottomLeftValue(TreeNode node, int currentLevel) {
        if (node == null) return;
        if (currentLevel > maxLevel) {
            maxLevel = currentLevel;
            res = node.val;
        }
        currentLevel++;
        findBottomLeftValue(node.left, currentLevel);
        findBottomLeftValue(node.right, currentLevel);
    }
}