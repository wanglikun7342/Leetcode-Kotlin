package com.eric.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NAryTreePreorderTraversal {
    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        preorderInternal(result, root);
        return result;
    }

    private void preorderInternal(List<Integer> list, Node root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        for (Node child : root.children) {
            preorderInternal(list, child);
        }
    }
}