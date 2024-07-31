/*
429. N-ary Tree Level Order Traversal

Given an n-ary tree, return the level order traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).

*/


class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        preorder(root, 0, res);
        return res;
    }

    private void preorder(Node node, int level, List<List<Integer>> res) {
        if (node == null) return;
        if (res.size() - 1 < level) {
            res.add(new ArrayList<>());
        }
        List<Integer> list = res.get(level);
        list.add(node.val);
        res.set(level, list);
        level++;
        for (Node child : node.children) {
            preorder(child, level, res);
        }
    }
}