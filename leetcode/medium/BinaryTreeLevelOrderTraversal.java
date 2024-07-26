/*
102. Binary Tree Level Order Traversal

Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).


Note: 
Binary tree traversal的应用. 因为我们递归中传中当下的level, 每次traverse一个node, level都需要increase. 关键在于判断何时增加一个inner array, 即应在的level比实际大的时候.
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        preorder(root, res, 0);
        return res;
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
}