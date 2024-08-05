/*
106. Construct Binary Tree from Inorder and Postorder Traversal

Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

Note:
Inorder: left -> node -> right
Postorder: left -> right -> node
Preorder: node -> left -> right
每次build subtree的时候,用postorder找到node,再找到inorder中node的index. 递归继续找node.left和node.right

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode buildTree(
        int[] inorder, 
        int[] postorder,
        int inStart,
        int inEnd,
        int postStart,
        int postEnd
        ) {
        if (inStart > inEnd || postStart > postEnd) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int rootIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val) {
                rootIndex = i;
                break;
            }
        }
        root.left = buildTree(inorder, postorder, inStart, rootIndex - 1, postStart, postStart + (rootIndex - inStart - 1));
        root.right = buildTree(inorder, postorder, rootIndex + 1, inEnd, postStart + (rootIndex - inStart), postEnd - 1);
        return root;
    }
}
