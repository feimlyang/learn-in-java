/*
116. Populating Next Right Pointers in Each Node

You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.
*/


class Solution {
    public Node connect(Node root) {
        List<List<Node>> res = new ArrayList<>();
        preorder(root, 0, res);
        return root;       
    }

    private void preorder(Node node, int level, List<List<Node>> res) {
        if (node == null) return;
        if (res.size() - 1 < level) {
            List<Node> list = new ArrayList<>();
            list.add(node);
            res.add(list);
        } else {
            List<Node> list = res.get(level);
            Node last = list.get(list.size() - 1);
            last.next = node;
            node.next = null;
            list.add(node);            
        }
        level++;
        preorder(node.left, level, res);
        preorder(node.right, level, res);
    }
}